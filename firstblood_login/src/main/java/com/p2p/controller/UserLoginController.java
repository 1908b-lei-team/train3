package com.p2p.controller;

import com.p2p.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userLoginControlle")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;
}
