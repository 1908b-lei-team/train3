package com.fh.service.control;

import com.fh.model.Control;
import com.fh.util.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
public interface ControlService{

    List<Control> queryList();

    ServerResponse addLoan(Control control, HttpServletRequest request);

    void updateInsName(List<Control> list);

    ServerResponse withdraw(Integer id, Double withdrawMoney, String password);
}
