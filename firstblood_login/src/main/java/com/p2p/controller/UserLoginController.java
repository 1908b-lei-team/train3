package com.p2p.controller;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.common.SystemConstant;
import com.fh.common.UserAnnotation;
import com.p2p.model.User;
import com.p2p.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("userLoginController")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    //用户注册
    @RequestMapping("register")
    public ServerResponse register(User user){
        userLoginService.register(user);
        return ServerResponse.successMethod();
    }

    //查询用户手机号
    @RequestMapping("queryByUserPhone")
    public ServerResponse queryByUserPhone(String userPhone){
        return userLoginService.queryByUserPhone(userPhone);
    }
    //查询用户名称
    @RequestMapping("queryByUserName")
    public ServerResponse queryByUserName(@RequestParam("userName") String userName){
        return userLoginService.queryByUserName(userName);
    }

    //用户登录
    @RequestMapping("userLogin")
    public ServerResponse userLogin(User user){
        return userLoginService.userLogin(user);
    }
}
