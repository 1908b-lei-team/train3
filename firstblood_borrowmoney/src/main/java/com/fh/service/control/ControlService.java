package com.fh.service.control;

import com.fh.model.Control;
import com.fh.util.ServerResponse;

import java.util.List;

public interface ControlService{

    List<Control> queryList();

    ServerResponse addLoan(Control control);

    void updateInsName(List<Control> list);
}
