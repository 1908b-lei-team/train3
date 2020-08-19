package com.fh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.common.ServerResponse;
import com.fh.mapper.PayMapper;
import com.fh.model.Pay;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper  payMapper;

    @Override
    public ServerResponse querybalance(Integer id) {
        QueryWrapper<Pay> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Pay pay = payMapper.selectById(queryWrapper);
        return ServerResponse.success(pay.getBalance());
    }

    @Override
    public ServerResponse queryList() {
        List<Pay> list = payMapper.selectList(null);
        return ServerResponse.success(list);
    }
}
