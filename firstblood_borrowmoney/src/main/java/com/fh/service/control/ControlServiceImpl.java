package com.fh.service.control;

import com.fh.mapper.ControlMapper;
import com.fh.model.Control;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public  class ControlServiceImpl implements ControlService {

    @Resource
    private ControlMapper controlMapper;

    @Override
    public List<Control> queryList() {
        return controlMapper.selectList(null);
    }
}
