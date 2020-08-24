package com.fh.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyErrorController implements ErrorController {
    @RequestMapping("error")
    public Map error(HttpServletRequest request, HttpServletResponse response) {
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String msg = (String) request.getAttribute("javax.servlet.error.message");
        Map<Object, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }
    @Override
    public String getErrorPath() {
        return null;
    }
}
