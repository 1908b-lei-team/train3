package com.fh.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    public Map error(HttpServletRequest request, HttpServletResponse response) {
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String msg = (String) request.getAttribute("javax.servlet.error.message");
        Map<Object, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        //
        response.setStatus(HttpStatus.OK.value());
        return map;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
