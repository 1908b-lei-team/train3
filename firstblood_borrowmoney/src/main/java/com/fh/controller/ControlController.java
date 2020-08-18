package com.fh.controller;

import com.fh.model.Control;
import com.fh.service.control.ControlService;
import com.fh.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("controlController")
public class ControlController {

    @Autowired
    private ControlService controlService;

    @RequestMapping("queryList")
    public ServerResponse queryList(){
       List<Control> list = controlService.queryList();
        return ServerResponse.success(list);
    }

}
