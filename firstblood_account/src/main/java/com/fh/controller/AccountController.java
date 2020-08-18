package com.fh.controller;

import com.fh.model.Account;
import com.fh.service.AccountService;
import com.fh.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    //验证 名称
    @RequestMapping("checkUserName")
    public ServerResponse checkName(String userName){
        return accountService.checkUserName(userName);
    }
    //验证 身份证
    @RequestMapping("checkIdNumber")
    public ServerResponse checkIdNumber(String idNumber){
        return accountService.checkIdNumber(idNumber);
    }
    //验证 银行卡
    @RequestMapping("checkCreditCardNumbers")
    public ServerResponse checkCreditCardNumbers(String checkCreditCardNumbers){
        return accountService.checkCreditCardNumbers(checkCreditCardNumbers);
    }
    //验证 手机
    @RequestMapping("checkBankPhone")
    public ServerResponse checkBankPhone(String bankPhone){
        return accountService.checkBankPhone(bankPhone);
    }


    // 开户
    @RequestMapping("addAccount")
    public ServerResponse addAccount(Account account){
        return accountService.addAccount(account);
    }
}
