package com.fh.service;


import com.fh.common.ServerResponse;

public interface PayService {
    //查询余额
    ServerResponse querybalance(Integer id);

    //查询
    ServerResponse queryList();
}
