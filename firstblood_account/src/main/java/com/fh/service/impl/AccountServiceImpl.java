package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.mapper.AccountMapper;
import com.fh.model.Account;
import com.fh.model.Attestation;
import com.fh.service.AccountService;
import com.fh.util.RandomCreditCardNumberGenerator;
import com.fh.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return ServerResponse.error("用户已存在");
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse checkIdNumber(String idNumber) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_number",idNumber);
        Account account = accountMapper.selectOne(queryWrapper);
        if (account!=null){
            return ServerResponse.error("此身份证已绑定其他账户。");
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse checkCreditCardNumbers(String checkCreditCardNumbers) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("credit_card_numbers",checkCreditCardNumbers);
        Account account = accountMapper.selectOne(queryWrapper);
        if (account!=null){
            return ServerResponse.error("此银行卡已绑定其他账户。");
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse checkBankPhone(String bankPhone) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bank_phone",bankPhone);
        Account account = accountMapper.selectOne(queryWrapper);
        if (account!=null){
            return ServerResponse.error("此号码已绑定其他账户");
        }
        return ServerResponse.success();
    }

    // 开户
    @Override
    public ServerResponse addAccount(Account account) {
        try {
            account.setNewTime(new Date());
            account.setUserId(5);
            String bank_account = RandomCreditCardNumberGenerator.get_Bank_account();
            account.setVirtualBankId(bank_account);
            accountMapper.insert(account);
        }catch (Exception e){
            return ServerResponse.error("开户失败，请稍后再试。");
        }
        return ServerResponse.success("恭喜您，开户成功。");
    }


    // 查询用户信息
    @Override
    public ServerResponse queryInfo2() {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",5);
        Account account = accountMapper.selectOne(queryWrapper);
        return ServerResponse.success(account);
    }

}
