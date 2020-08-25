package com.fh.filter;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.SystemConstant;
import com.fh.common.model.User;
import com.fh.common.util.JwtUtil;
import com.fh.exception.LoginException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Component
public class LoginFilter extends ZuulFilter {

    @Value("${check.urls}")
    private String[] urls;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        String uri=request.getRequestURI();
        for (String url : urls) {
            if(uri.contains(url)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest  request = ctx.getRequest();
            HttpServletResponse response = ctx.getResponse();
            response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,"x-auth,mtoken,content-type");
            response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,"PUT,POST,DELETE,GET");

            String token = request.getHeader("x-auth");
            if (StringUtils.isEmpty(token)){
                throw new LoginException("没有登录",1002,"");
            }
            boolean verify = JwtUtil.verify(token);
            if (verify){//验证token
                String user = JwtUtil.getUser(token);
                String decode = URLDecoder.decode(user, "utf-8");
                ctx.addZuulRequestHeader(SystemConstant.SESSION_KEY,decode);
                ctx.addZuulRequestHeader(SystemConstant.TOKEN_KEY,token);
            }else {
                throw new LoginException("没有登录",1002,"没有登录");

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
