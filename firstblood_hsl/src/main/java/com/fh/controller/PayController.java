package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.service.PayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("pay")
public class PayController {
    @Resource
    private PayService payService;


    @RequestMapping("queryList")
    public  ServerResponse  queryList(){
        return payService.queryList();
    }





}
