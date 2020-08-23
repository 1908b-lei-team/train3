package com.fh.service;

import com.fh.model.Account;
import com.fh.util.ServerResponse;

public interface AccountService {

    ServerResponse addAccount(Account account);

    ServerResponse checkUserName(String userName);

    ServerResponse checkIdNumber(String idNumber);

    ServerResponse checkCreditCardNumbers(String checkCreditCardNumbers);

    ServerResponse checkBankPhone(String bankPhone);

    ServerResponse queryInfo2();
}
