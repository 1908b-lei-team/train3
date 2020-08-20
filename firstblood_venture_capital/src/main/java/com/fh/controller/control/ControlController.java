package com.fh.controller.control;

import com.fh.common.ServerResponse;
import com.fh.model.Control;
import com.fh.service.control.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("control")
@RestController
public class ControlController {


    @Autowired
    private ControlService controlService;

    /**
     * 查询所有的信息
     * @return
     */
    @RequestMapping("queryList")
    public ServerResponse queryList(){
        return  controlService.queryList();
    }

    /**
     * 插入
     * @param control
     * @return
     */
    @RequestMapping("insertControl")
    public ServerResponse insertControl(Control control){

        controlService.insertControl(control);
        return  ServerResponse.successMethod();
    }

    @RequestMapping("updateControl")
    public ServerResponse updateControl(Control control){
        controlService.updateControl(control);
        return  ServerResponse.successMethod();
    }

    @RequestMapping("deleteControl")
    public ServerResponse deleteControl(Integer id){
        controlService.deleteControl(id);
        return  ServerResponse.successMethod();
    }


    @RequestMapping("deleteBatch")
    public ServerResponse deleteBatch(List<Integer> idList){
        controlService.deleteBatch(idList);
        return  ServerResponse.successMethod();
    }
}
