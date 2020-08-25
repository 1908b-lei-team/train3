package com.fh.service.control;

import com.fh.common.ServerResponse;
import com.fh.model.Control;
import com.fh.param.ControParam;

import java.util.List;

public interface ControlService {
    ServerResponse queryList();

    void insertControl(Control control);

    void updateControl(Control control);

    void deleteControl(Integer id);

    void deleteBatch(List<Integer> idList);

    ServerResponse queryListPage(ControParam controParam);

    ServerResponse queryCheckInfo(Integer id);

    void updateCheckStatu(String status, Integer userId);
}
