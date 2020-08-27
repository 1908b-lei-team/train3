package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Bill;
import com.fh.service.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("billController")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping("queryBillList")
    public ServerResponse queryBillList(){
      List<Bill> list = billService.queryBillList();
        return ServerResponse.successMethod(list);
    }

}
