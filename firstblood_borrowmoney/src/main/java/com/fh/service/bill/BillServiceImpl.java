package com.fh.service.bill;

import com.fh.mapper.BillMapper;
import com.fh.model.Bill;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper billMapper;

    @Override
    public List<Bill> queryBillList() {
        return billMapper.selectList(null);
    }
}
