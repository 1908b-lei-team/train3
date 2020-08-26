package com.fh.service;

import com.fh.model.Account;
import com.fh.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public interface AccountService {

    ServerResponse addAccount(Account account, HttpServletRequest request);

    ServerResponse checkUserName(String userName);

    ServerResponse checkIdNumber(String idNumber);

    ServerResponse checkCreditCardNumbers(String checkCreditCardNumbers);

    ServerResponse checkBankPhone(String bankPhone);

    ServerResponse queryInfo2(HttpServletRequest request);
}
