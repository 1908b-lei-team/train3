package com.fh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.common.SystemConstant;
import com.fh.mapper.AccountMapper;
import com.fh.model.Account;
import com.fh.service.AccountService;
import com.fh.util.RandomCreditCardNumberGenerator;
import com.fh.common.ServerResponse;
import com.p2p.model.User;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;


    // 验证 用户是否存在
    @Override
    public ServerResponse checkUserName(String userName) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        Account account = accountMapper.selectOne(queryWrapper);
        if (account!=null){
            return ServerResponse.errorMethod(2000);
        }
        return ServerResponse.successMethod(1000);
    }

    @Override
    public ServerResponse checkIdNumber(String idNumber) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_number",idNumber);
        Account account = accountMapper.selectOne(queryWrapper);
        if (account!=null){
            return ServerResponse.errorMethod(2000);
        }
        return ServerResponse.successMethod(1000);
    }

    @Override
    public ServerResponse checkCreditCardNumbers(String checkCreditCardNumbers) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("credit_card_numbers",checkCreditCardNumbers);
        Account account = accountMapper.selectOne(queryWrapper);
        if (account!=null){
            return ServerResponse.errorMethod(2000);
        }
        return ServerResponse.successMethod(1000);
    }

    @Override
    public ServerResponse checkBankPhone(String bankPhone) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bank_phone",bankPhone);
        Account account = accountMapper.selectOne(queryWrapper);
        if (account!=null){
            return ServerResponse.errorMethod(2000);
        }
        return ServerResponse.successMethod(1000);
    }

    // 开户
    @Override
    public ServerResponse addAccount(Account account,HttpServletRequest request) {
        String header = request.getHeader(SystemConstant.SESSION_KEY);
        User user = JSONObject.parseObject(header, User.class);
        if (user != null){
            account.setNewTime(new Date());
            account.setUserId(user.getId());
            String bank_account = RandomCreditCardNumberGenerator.get_Bank_account();
            account.setVirtualBankId(bank_account);
            accountMapper.insert(account);
            return ServerResponse.successMethod(1000);
        }
            return ServerResponse.errorMethod(2000);
    }


    // 查询用户信息
    @Override
    public ServerResponse queryInfo2(HttpServletRequest request) {
        String header = request.getHeader(SystemConstant.SESSION_KEY);
        User user = JSONObject.parseObject(header, User.class);
        if (user != null){
            QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",user.getId());
            Account account = accountMapper.selectOne(queryWrapper);
            return ServerResponse.successMethod(account);
        }
        return ServerResponse.errorMethod(2000);
    }

}
