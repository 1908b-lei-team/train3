package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.fh.mapper.UserMapper;
import com.fh.model.Account;
import com.fh.model.User;
import com.fh.service.UserService;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryStatus(Integer id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public void updStatus(User user) {
        userMapper.updateById(user);
    }

}
