package com.p2p.service;

import com.p2p.mapper.UserLoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginMapper;
}
