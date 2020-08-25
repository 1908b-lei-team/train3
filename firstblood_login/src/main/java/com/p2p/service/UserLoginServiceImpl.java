package com.p2p.service;

import com.netflix.zuul.context.RequestContext;
import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.common.SystemConstant;
import com.p2p.mapper.UserLoginMapper;
import com.p2p.model.User;
import com.p2p.util.JwtUtil;
import com.p2p.util.MD5Util;
import com.p2p.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginMapper;

    //注册
    @Override
    public void register(User user) {

        user.setFoundtime(new Date());

        user.setUserpwd(MD5Util.md5Hex(user.getUserpwd()));

        userLoginMapper.register(user);

    }

    //查询用户提交的手机号
    @Override
    public ServerResponse queryByUserPhone(String userPhone) {

        User user = userLoginMapper.queryByUserPhone(userPhone);

        //判断用户注册的手机号是否存在如果存在返回一个状态告诉用户手机号已注册
        if (user==null){
            return ServerResponse.successMethod();
        }

        return ServerResponse.errorMethod();
    }

    //用户登录
    @Override
    public ServerResponse userLogin(User user) {

        //查询用户输入的手机号
        User queryByUserPhone = userLoginMapper.queryByUserPhone(user.getUserphone());

        //判断用户是否存在
        if(queryByUserPhone==null){
            return ServerResponse.errorMethod("手机号不存在");
        }

        //超过24小时解除限制
        if(queryByUserPhone.getLogintime()!=null){
            long time = queryByUserPhone.getLogintime().getTime();
            long time1= new Date().getTime();
            System.out.println(new Date());
            long time2 = 1000*60*60*24;
            if(time1-time>time2){
                queryByUserPhone.setLogincount(0);
                queryByUserPhone.setLoginstatus(null);
                queryByUserPhone.setLogintime(null);
                userLoginMapper.updateLogincount(queryByUserPhone);
            }else {
                return ServerResponse.errorMethod("该账号已锁定请第二天在尝试登录");
            }
        }
        if("锁定".equals(queryByUserPhone.getLoginstatus())){
            return ServerResponse.errorMethod("该账号已锁定请第二天在尝试登录");
        }



        //吧用户输入的密码进行和注册时加密的手法一致
        String LoginUserpwd = MD5Util.md5Hex(user.getUserpwd());
        System.out.println(LoginUserpwd);
        if(!LoginUserpwd.equals(queryByUserPhone.getUserpwd())){
            queryByUserPhone.setLogincount(queryByUserPhone.getLogincount()+1);
                if(queryByUserPhone.getLogincount()==3){
                    queryByUserPhone.setLoginstatus("锁定");
                    queryByUserPhone.setLogintime(new Date());
                    userLoginMapper.updateLoginstatus(queryByUserPhone);
                    return ServerResponse.errorMethod("密码错误3次该账号已被锁定");
                }
            userLoginMapper.updateLogincount(queryByUserPhone);
            return ServerResponse.errorMethod("密码不正确，目前密码错误次数"+queryByUserPhone.getLogincount()+"如果超过三次将被锁定一天");
        }
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = null;
        try {
            String jsonString = JSONObject.toJSONString(queryByUserPhone);
            String encode = URLEncoder.encode(jsonString, "utf-8");
            token = JwtUtil.sign(encode);
            ctx.addZuulRequestHeader(SystemConstant.SESSION_KEY,encode);
            ctx.addZuulRequestHeader(SystemConstant.TOKEN_KEY,token);
            RedisUtil.set(token,token,30*60*1000);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ServerResponse.successMethod(token);
    }

    @Override
    public ServerResponse queryByUserName(String userName) {
        User user = userLoginMapper.queryByUserName(userName);
        return ServerResponse.successMethod(user);
    }
}
