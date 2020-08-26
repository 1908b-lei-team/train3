package com.fh.controller;

import com.fh.model.Attestation;
import com.fh.service.AttestationService;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("attestation")
//@CrossOrigin
public class AttestationController {

    @Autowired
    private AttestationService attestationService;

    //实名
    @RequestMapping("realNameAuthentication")
    public ServerResponse realNameAuthentication(Attestation attestation, HttpServletRequest request){
        return attestationService.realNameAuthentication(attestation,request);
    }

    //验证 身份证
    @RequestMapping("checkIdNumber2")
    public ServerResponse checkIdNumber(String idNumber){
        return attestationService.checkIdNumber(idNumber);
    }

    @RequestMapping("queryInfo")
    public ServerResponse queryInfo(HttpServletRequest request){
        return attestationService.queryInfo(request);
    }

}
