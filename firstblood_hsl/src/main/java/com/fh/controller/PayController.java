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


    //查询账户余额
    @RequestMapping("querygeneralassets")
    public  ServerResponse  querygeneralassets(Integer id){
        return payService.querygeneralassets(id);
    }


    @RequestMapping("onSubmit")
    public  ServerResponse  onSubmit(Pay pay){
        return  payService.onSubmit(pay);
    }



    //查询账户当前可用余额
    @RequestMapping("querybalance")
    public  ServerResponse  querybalance(Integer id){
        return payService.querybalance(id);
    }


   /* //去充值
    @RequestMapping("gotop")
    public  ServerResponse  gotop(Pay pay){
    return  payService.gotop(pay);
    }*/


   //充值提交
    @RequestMapping("commith")
    public  ServerResponse  commith(Pay pay){
       return payService.commith(pay);
   }
}
