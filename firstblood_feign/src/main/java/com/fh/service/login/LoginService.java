package com.fh.service.login;

import com.fh.common.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "login",fallback = LoginServiceImpl.class)
public interface LoginService {

    @RequestMapping("userLoginController/queryByUserName")
    ServerResponse queryByUserName(@RequestParam("userName") String userName);
}
