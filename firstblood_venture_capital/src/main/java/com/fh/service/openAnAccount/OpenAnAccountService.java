package com.fh.service.openAnAccount;

import com.fh.common.ServerResponse;
import com.fh.model.OpenAnAccount;
import com.fh.param.OpenAnAccountParam;

import java.util.List;

public interface OpenAnAccountService {
    ServerResponse queryList();

    void insertOpenAnAccount(OpenAnAccount openAnAccount);

    void updateOpenAnAccount(OpenAnAccount openAnAccount);

    void deleteOpenAnAccount(Integer id);

    void deleteBatch(List<Integer> idList);


    ServerResponse queryListPage(OpenAnAccountParam openAnAccountParam);
}
