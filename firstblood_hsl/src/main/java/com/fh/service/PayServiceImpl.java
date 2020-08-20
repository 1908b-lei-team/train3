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



    //查询信息
    @Override
    public ServerResponse queryList() {
        List<Pay> list = payMapper.selectList(null);
        return ServerResponse.success(list);
    }

    @Override
    public ServerResponse querygeneralassets(Integer id) {
        Pay pay = payMapper.selectById(id);
        return ServerResponse.success(pay.getGeneralassets());
    }


}
