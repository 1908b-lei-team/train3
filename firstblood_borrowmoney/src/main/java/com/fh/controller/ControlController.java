package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Control;
import com.fh.service.control.ControlService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
        return ServerResponse.successMethod(map);
    }
    @RequestMapping("addLoan")
    public ServerResponse addLoan(Control control,HttpServletRequest request){
        return  controlService.addLoan(control,request);
    }

    public void updateInsName(List<Control> list){
        controlService.updateInsName(list);
    }

    @RequestMapping("withdraw")
    public ServerResponse withdraw(Integer id, @Param("withdrawMoney") Double withdrawMoney, @Param("password")String password){
        return  controlService.withdraw(id,withdrawMoney,password);
    }


}
