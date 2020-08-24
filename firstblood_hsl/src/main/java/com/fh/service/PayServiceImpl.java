package com.fh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.common.ServerResponse;
import com.fh.mapper.PayMapper;
import com.fh.model.Pay;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    public ServerResponse onSubmit(Pay pay) {
        Pay pay1 = payMapper.selectById(pay.getId());
        if(!pay1.getDealpassword().equals(pay.getDealpassword()) ){
            return  ServerResponse.error("支付密码不正确");
        }

        BigDecimal bigDecimal = new BigDecimal(500000);
        int i = bigDecimal.compareTo(pay.getLoanamount());  //i=-1小于  0 等于  1大于
        int i2 = bigDecimal.compareTo(pay1.getGeneralassets());  //i=-1小于  0 等于  1大于

        //(BigDecimal怎么比较大小  )
        if (i==-1 && i2==-1){

            //应该吧借出余额存在对应的用户上
            pay1.setLoanamount(pay.getLoanamount());
            payMapper.updateLoanamount(pay1);

        }else{
            return  ServerResponse.error("超出出借金额");
        }

        return ServerResponse.success() ;
    }


}
