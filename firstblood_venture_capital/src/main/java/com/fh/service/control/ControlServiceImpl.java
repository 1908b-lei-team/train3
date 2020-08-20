package com.fh.service.control;

import com.fh.mapper.control.ControlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ControlServiceImpl implements ControlService {

    @Resource
    private ControlMapper controlMapper;
}
