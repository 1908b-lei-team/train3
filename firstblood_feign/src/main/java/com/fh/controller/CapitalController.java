package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.User;
import com.fh.service.capital.CapitalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("feign")
public class CapitalController {
    @Resource
    private CapitalService demoService;
    @RequestMapping("test")
    public ServerResponse queryCheckInfo(Integer id){
        return demoService.queryCheckInfo(id);
    }
    @RequestMapping("test1")
    public String test1(){
        User user = new User();
        user.setName("ljy");
        user.setId(1);
        return demoService.test1(user);
    }
}
