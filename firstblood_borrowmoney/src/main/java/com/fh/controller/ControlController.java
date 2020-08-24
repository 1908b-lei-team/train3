package com.fh.controller;

import com.fh.model.Control;
import com.fh.service.control.ControlService;
import com.fh.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("controlController")
public class ControlController {

    @Autowired
    private ControlService controlService;

    @RequestMapping("queryList")
    public ServerResponse queryList(){
       List<Control> list = controlService.queryList();
        updateInsName(list);
        List<Control> list1 = controlService.queryList();
        Map<String,Object> map = new HashMap();
        map.put("list",list1);
        return ServerResponse.success(map);
    }
    @RequestMapping("addLoan")
    public ServerResponse addLoan(Control control){
        return  controlService.addLoan(control);
    }

    public void updateInsName(List<Control> list){
        controlService.updateInsName(list);
    }


}
