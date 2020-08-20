package com.fh.controller.openAnAccount;

import com.fh.common.ServerResponse;
import com.fh.model.Control;
import com.fh.model.OpenAnAccount;
import com.fh.param.OpenAnAccountParam;
import com.fh.service.openAnAccount.OpenAnAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("openAnAccount")
@RestController
public class OpenAnAccountController {

    @Autowired
    private OpenAnAccountService openAnAccountService;


    /**
     * 查询所有的信息
     * @return
     */
    @PostMapping("/queryList")
    public ServerResponse queryList(){
        return  openAnAccountService.queryList();
    }

    @PostMapping("/queryListPage")
    public ServerResponse queryListPage(OpenAnAccountParam openAnAccountParam){
        return  openAnAccountService.queryListPage(openAnAccountParam);
    }

    /**
     * 插入
     * @param
     * @return
     */
    @PostMapping("insertOpenAnAccount")
    public ServerResponse insertOpenAnAccount(OpenAnAccount openAnAccount){

        openAnAccountService.insertOpenAnAccount(openAnAccount);
        return  ServerResponse.successMethod();
    }

    @PostMapping("updateControl")
    public ServerResponse updateOpenAnAccount(OpenAnAccount openAnAccount){
        openAnAccountService.updateOpenAnAccount(openAnAccount);
        return  ServerResponse.successMethod();
    }

    @PostMapping("deleteControl")
    public ServerResponse deleteOpenAnAccount(Integer id){
        openAnAccountService.deleteOpenAnAccount(id);
        return  ServerResponse.successMethod();
    }


    @PostMapping("deleteBatch")
    public ServerResponse deleteBatch(List<Integer> idList){
        openAnAccountService.deleteBatch(idList);
        return  ServerResponse.successMethod();
    }
}
