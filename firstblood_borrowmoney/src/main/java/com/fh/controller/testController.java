package com.fh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testController")
public class testController {

    @RequestMapping("test")
    public String test(){
        return "success";
    }

}
