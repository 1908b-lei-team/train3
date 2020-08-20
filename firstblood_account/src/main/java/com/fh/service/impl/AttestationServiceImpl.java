package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.mapper.AttestationMapper;
import com.fh.model.Account;
import com.fh.model.Attestation;
import com.fh.model.User;
import com.fh.service.AttestationService;
import com.fh.service.UserService;
import com.fh.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttestationServiceImpl implements AttestationService {

    @Autowired
    private AttestationMapper attestationMapper;

    @Autowired
    private UserService userService;

    @Override
    public ServerResponse realNameAuthentication(Attestation attestation) {

        Integer id = 5;

        User u = userService.queryStatus(id);
        if (u.getUserStatus().equals("0")){
            User user = new User();
            user.setId(id);
            user.setIdNumber(attestation.getIdNumber());
            user.setUserStatus("1");
            attestation.setUserId(id);
            attestationMapper.insert(attestation);
            userService.updStatus(user);
        }
        return ServerResponse.success("实名认证成功");
    }

    @Override
    public ServerResponse checkIdNumber(String idNumber) {
        QueryWrapper<Attestation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_number",idNumber);
        Attestation attestation = attestationMapper.selectOne(queryWrapper);
        if (attestation!=null){
            return ServerResponse.error("此身份证已绑定其他账户。");
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse queryInfo() {
        QueryWrapper<Attestation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",5);
        Attestation attestation = attestationMapper.selectOne(queryWrapper);
        return ServerResponse.success(attestation);
    }


}
