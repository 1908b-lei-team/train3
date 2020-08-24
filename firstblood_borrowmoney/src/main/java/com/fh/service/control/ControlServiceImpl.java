package com.fh.service.control;

import com.fh.mapper.ControlMapper;
import com.fh.model.Control;
import com.fh.util.ServerResponse;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public  class ControlServiceImpl implements ControlService {

    @Resource
    private ControlMapper controlMapper;

    @Override
    public List<Control> queryList() {
        return controlMapper.selectList(null);
    }

    @Override
    public ServerResponse addLoan(Control control) {
        if (control.getBorrowMoney()>=50000.0){
           return ServerResponse.error("借款金额最高为50000");
        }
        String number="";
        //获取当前时间戳
        SimpleDateFormat sf = new SimpleDateFormat("yyMdd");
        String temp = sf.format(new Date());
        //获取4位随机数
        int random=(int) ((Math.random()+1)*1000);
        number=temp+random;
        control.setNumber(number);
        //FIRST_TRIAL 初审
        control.setStatus("初审中");
        control.setRateSchedule(0.0);
        control.setAnnualRate(10.0);
        control.setLoanTime(new Date());
        controlMapper.insert(control);
        return ServerResponse.success();
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
}
