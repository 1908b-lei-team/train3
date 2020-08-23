package com.fh.service.capital;

import com.fh.model.User;
import org.springframework.stereotype.Component;

@Component
public class CapitalServiceHystrix implements CapitalService {
    @Override
    public String test(String name) {
        return "404 error";
    }

    @Override
    public String test1(User user) {
        return "对象404";
    }
}
