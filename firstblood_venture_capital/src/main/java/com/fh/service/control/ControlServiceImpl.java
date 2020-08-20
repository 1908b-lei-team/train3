package com.fh.service.control;

import com.fh.common.ServerResponse;
import com.fh.mapper.control.ControlMapper;
import com.fh.model.Control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ControlServiceImpl implements ControlService {

    @Resource
    private ControlMapper controlMapper;

    @Override
    public ServerResponse queryList() {
        List<Control> controlList = controlMapper.selectList(null);
        return ServerResponse.successMethod(controlList);
    }

    @Override
    public void insertControl(Control control) {
        controlMapper.insert(control);
    }

    @Override
    public void updateControl(Control control) {

        controlMapper.updateById(control);
    }

    @Override
    public void deleteControl(Integer id) {

        controlMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> idList) {

        controlMapper.deleteBatchIds(idList);
    }
}
