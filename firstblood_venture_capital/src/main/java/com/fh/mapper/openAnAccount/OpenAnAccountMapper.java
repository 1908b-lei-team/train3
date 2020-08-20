package com.fh.mapper.openAnAccount;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.OpenAnAccount;
import com.fh.param.OpenAnAccountParam;
import com.fh.vo.OpenAnAccountVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OpenAnAccountMapper extends BaseMapper<OpenAnAccount> {
    Integer selCount();

    List<OpenAnAccountVo> queryListPage(OpenAnAccountParam openAnAccountParam);
}
