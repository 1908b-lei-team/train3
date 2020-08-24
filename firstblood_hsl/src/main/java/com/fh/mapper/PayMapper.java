package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Pay;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface PayMapper extends BaseMapper<Pay> {

    void addLoanamount(BigDecimal loanamount);

}
