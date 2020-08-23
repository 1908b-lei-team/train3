package com.fh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.common.ServerResponse;
import com.fh.mapper.PayMapper;
import com.fh.model.Pay;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    //查询余额
    @Override
    public ServerResponse querygeneralassets(Integer id) {
        Pay pay = payMapper.selectById(id);
        return ServerResponse.success(pay.getGeneralassets());
    }

    @Override
    public ServerResponse onSubmit(Pay pay,Integer id) {
        Pay pay1 = payMapper.selectById(id);
        if(!pay1.getDealpassword().equals(pay.getDealpassword())){
            return  ServerResponse.error("支付密码不正确");
        }
        if (500000<pay.getLoanamount()){
            return  ServerResponse.error("超出出借金额");
        }else{
            payMapper.addLoanamount(pay.getLoanamount());
        }

        return ServerResponse.success() ;
    }


}
