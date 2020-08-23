package com.fh.service.control;

import com.fh.mapper.ControlMapper;
import com.fh.model.Control;
import com.fh.util.ServerResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public  class ControlServiceImpl implements ControlService {

    @Resource
    private ControlMapper controlMapper;

    @Override
    public List<Control> queryList() {
        return controlMapper.queryList();
    }

    @Override
    public ServerResponse addLoan(Control control) {
        controlMapper.insert(control);
        return ServerResponse.success();
    }

}
