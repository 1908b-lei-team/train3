package com.fh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.common.SystemConstant;
import com.fh.mapper.AttestationMapper;
import com.fh.model.Attestation;
import com.p2p.model.User;
import com.fh.service.AttestationService;
import com.fh.service.UserService;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AttestationServiceImpl implements AttestationService {

    @Autowired
    private AttestationMapper attestationMapper;

    @Autowired
    private UserService userService;

    @Override
    public ServerResponse realNameAuthentication(Attestation attestation, HttpServletRequest request) {
        String header = request.getHeader(SystemConstant.SESSION_KEY);
        User user = JSONObject.parseObject(header, User.class);

        if(user != null){
            com.fh.model.User u = userService.queryStatus(user.getId());
            if (u.getUserStatus().equals("0")){
                com.fh.model.User u2 = new com.fh.model.User();
                u2.setId(user.getId());
                u2.setIdNumber(attestation.getIdNumber());
                u2.setUserStatus("1");
                attestation.setUserId(user.getId());
                attestationMapper.insert(attestation);
                userService.updStatus(u2);
            }
            return ServerResponse.successMethod(1000);
        }
        return  ServerResponse.errorMethod(2000);
    }

    @Override
    public ServerResponse checkIdNumber(String idNumber) {
        QueryWrapper<Attestation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_number",idNumber);
        Attestation attestation = attestationMapper.selectOne(queryWrapper);
        if (attestation!=null){
            return ServerResponse.errorMethod(2000);
        }
        return ServerResponse.successMethod(1000);
    }

    @Override
    public ServerResponse queryInfo(HttpServletRequest request) {
        String header = request.getHeader(SystemConstant.SESSION_KEY);
        com.p2p.model.User user = JSONObject.parseObject(header, com.p2p.model.User.class);
        if (user != null){
            QueryWrapper<Attestation> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",user.getId());
            Attestation attestation = attestationMapper.selectOne(queryWrapper);
            return ServerResponse.successMethod(attestation);
        }
        return ServerResponse.errorMethod(2000);

    }


}
