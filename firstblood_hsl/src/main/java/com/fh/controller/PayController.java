package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Pay;
import com.fh.service.PayService;
import io.swagger.models.auth.In;
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


    @RequestMapping("querygeneralassets")
    public  ServerResponse  querygeneralassets(Integer id){
        return payService.querygeneralassets(id);
    }


    @RequestMapping("onSubmit")
    public  ServerResponse  onSubmit(Pay pay, Integer id){
        return  payService.onSubmit(pay,id);
    }

}
