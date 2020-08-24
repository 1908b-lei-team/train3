package com.fh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.common.ServerResponse;
import com.fh.mapper.PayMapper;
import com.fh.model.Pay;
import com.fh.model.Relevance;
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
        //user id
        QueryWrapper<Pay> queryWrapper = new QueryWrapper<>();
        //12是用户id   从登录拦截的session中获取
        queryWrapper.eq("user_id",12);
        Pay pay1 = payMapper.selectOne(queryWrapper);
        if(!pay1.getDealpassword().equals(pay.getDealpassword()) ){
            return  ServerResponse.error("支付密码不正确");
        }

        BigDecimal bigDecimal = new BigDecimal(50000);
        int i = bigDecimal.compareTo(pay.getLoanamount());  //i=-1小于  0 等于  1大于
        int i2 = pay.getLoanamount().compareTo(pay1.getGeneralassets());  //i=-1小于  0 等于  1大于

        //(BigDecimal怎么比较大小  )
        if (i==1 && i2==-1){

            //应该吧借出余额存在对应的用户上
            BigDecimal subtract = pay1.getGeneralassets().subtract(pay.getLoanamount());
            //当前可用余额
            pay1.setBalance(subtract);
            pay1.setLoanamount(pay1.getLoanamount().add(pay.getLoanamount()));
            payMapper.updateById(pay1);

            //保存relevance
            Relevance relevance = new Relevance();
            relevance.setFreezeMoney(pay.getLoanamount());
            relevance.setSignId(pay.getId());
            //从登录拦截的session中获取
            relevance.setUserId(12);
            payMapper.insertRelevance(relevance);

        }else{
            return  ServerResponse.error("超出出借金额");
        }

        return ServerResponse.success() ;
    }

    //查询当前可用余额
    @Override
    public ServerResponse querybalance(Integer id) {
        Pay pay = payMapper.selectById(id);
        return ServerResponse.success(pay.getBalance());
    }

    //去充值
/*    @Override
    public ServerResponse gotop(Pay pay) {

        BigDecimal bigDecimal = new BigDecimal(10);
        int i = bigDecimal.compareTo(pay.getPaymoney());//i=-1小于  0 等于  1大于
        //判断充值余额要大于10
        if(i==-1){
            return  ServerResponse.error("最少充值10元");
        }
        QueryWrapper<Pay> queryWrapper = new QueryWrapper<>();
        //12是用户id   从登录拦截的session中获取
        queryWrapper.eq("user_id",12);
        Pay pay1 = payMapper.selectOne(queryWrapper);
        return null;
    }*/


}
