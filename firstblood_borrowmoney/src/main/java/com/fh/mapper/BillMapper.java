package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Bill;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

@Mapper
public interface BillMapper extends BaseMapper<Bill> {

}
