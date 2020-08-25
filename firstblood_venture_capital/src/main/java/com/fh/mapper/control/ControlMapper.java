package com.fh.mapper.control;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Control;
import com.fh.param.ControParam;
import com.fh.vo.CheckInfoVo;
import com.fh.vo.ControlVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ControlMapper extends BaseMapper<Control> {
    Integer selCount();

    List<ControlVo> queryListPage(ControParam controParam);

    CheckInfoVo queryCheckInfo(Integer id);

    void updateCheckStatu(@Param("status") String status, @Param("userId") Integer userId, @Param("reviewTime") Date reviewTime);
}
