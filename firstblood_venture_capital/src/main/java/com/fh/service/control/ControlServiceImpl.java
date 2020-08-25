package com.fh.service.control;

import com.fh.common.ServerResponse;
import com.fh.mapper.control.ControlMapper;
import com.fh.model.Control;
import com.fh.param.ControParam;
import com.fh.vo.CheckInfoVo;
import com.fh.vo.ControlVo;
import com.fh.vo.OpenAnAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Override
    public ServerResponse queryListPage(ControParam controParam) {
        ///查询分页的数据

        //查询总条数
        Integer count = controlMapper.selCount();
        //把总条数放入page
        controParam.setCount(count);
        Integer startNum =(controParam.getCurrentPage()-1)*controParam.getPagesize();
        controParam.setStartNum(startNum);
        List<ControlVo> list = controlMapper.queryListPage(controParam);
        controParam.setList(list);

        return ServerResponse.successMethod(controParam);
    }

    @Override
    public ServerResponse queryCheckInfo(Integer id) {
        CheckInfoVo checkInfoVo = controlMapper.queryCheckInfo(id);
        return ServerResponse.successMethod(checkInfoVo);
    }

    @Override
    public void updateCheckStatu(String status, Integer userId) {
        Date reviewTime = new Date();
        controlMapper.updateCheckStatu(status,userId,reviewTime);
    }
}
