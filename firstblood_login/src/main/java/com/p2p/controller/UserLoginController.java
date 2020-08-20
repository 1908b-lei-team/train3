package com.p2p.controller;

import com.p2p.model.User;
import com.p2p.service.UserLoginService;
import com.p2p.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userLoginControlle")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    //用户注册
    @RequestMapping("register")
    public ServerResponse register(User user){
            userLoginService.register(user);
            return ServerResponse.success();
    }

    //查询用户手机号
    @RequestMapping("queryByUserPhone")
    public ServerResponse queryByUserPhone(String userPhone){
        return userLoginService.queryByUserPhone(userPhone);
    }
    //用户登录
    @RequestMapping("userLogin")
    public ServerResponse userLogin(User user){
        return userLoginService.userLogin(user);
    }
}
