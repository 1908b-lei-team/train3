package com.fh.service.control;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.common.SystemConstant;
import com.fh.mapper.ControlMapper;
import com.fh.model.Control;
import com.p2p.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public  class ControlServiceImpl implements ControlService {

    @Autowired
    private ControlMapper controlMapper;

    @Override
    public List<Control> queryList() {
        return controlMapper.selectList(null);
    }

    @Override
    public ServerResponse addLoan(Control control, HttpServletRequest request) {
        String header = request.getHeader(SystemConstant.SESSION_KEY);
        User user = JSONObject.parseObject(header, User.class);
        if (user != null) {
            if (control.getBorrowMoney()>=50000.0){
                return ServerResponse.errorMethod("借款金额最高为50000");
            }
            String number="";
            SimpleDateFormat sf = new SimpleDateFormat("yyMdd");
            String temp = sf.format(new Date());
            int random=(int) ((Math.random()+1)*1000);
            number=temp+random;
            control.setNumber(number);
            control.setUserId(user.getId());
            control.setStatus("初审中");
            control.setRateSchedule(0.0);
            control.setAnnualRate(10.0);
            control.setLoanTime(new Date());
            controlMapper.insert(control);
            return ServerResponse.successMethod();
        }
        return ServerResponse.errorMethod();
    }
    @Override
    public void updateInsName(List<Control> list) {
        for (int i = 0; i < list.size(); i++) {
            Control control = list.get(i);
            if (control.getStatus().equals("初审中")){
                //初审中
                control.setRateSchedule(0.0);
            }
            if (control.getStatus().equals("初审未通过")){
                //初审未通过  FIRST_TRIAL_NO_CHECK
                control.setRateSchedule(0.0);
            }
            if (control.getStatus().equals("初审通过")){
                control.setStatus("复审中");
                //初审通过
                control.setRateSchedule(0.0);
            }
            if (control.getStatus().equals("复审中")){
                //复审
                control.setRateSchedule(0.0);
            }
            if (control.getStatus().equals("复审未通过")){
                control.setRateSchedule(0.0);
            }
            if (control.getStatus().equals("复审通过")){
                control.setStatus("待放款");
                control.setRateSchedule(100.0);
            }
            if (control.getStatus().equals("借款中")){
                //借款中
                control.setRateSchedule(8.0);
            }
            if (control.getStatus().equals("待放款")){
                //待放款
                control.setRateSchedule(100.0);
            }
            if (control.getStatus().equals("还款中")){
                //借钱状态
                control.setRateSchedule(100.0);
            }
            if (control.getStatus().equals("已完成")){
                //借钱状态
                control.setRateSchedule(100.0);
            }
            if (control.getStatus().equals("流标")){
                //借钱状态
                control.setRateSchedule(60.0);
            }
            controlMapper.updateById(control);
        }
    }

    @Override
    public ServerResponse withdraw(Integer id, Double withdrawMoney, String password) {
        return null;
    }
}
