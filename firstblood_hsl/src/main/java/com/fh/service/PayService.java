package com.fh.service;


import com.fh.common.ServerResponse;
import com.fh.model.Pay;

public interface PayService {


    //查询
    ServerResponse queryList();

    ServerResponse querygeneralassets(Integer id);

    ServerResponse onSubmit(Pay pay);

    ServerResponse querybalance(Integer id);

    ServerResponse commith(Pay pay);

    /* ServerResponse gotop(Pay pay);*/
}
