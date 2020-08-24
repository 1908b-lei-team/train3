package com.fh.service.login;

import com.fh.common.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "login",fallback = LoginServiceImpl.class)
public interface LoginService {

    @RequestMapping("userLoginControlle/queryByUserName")
    ServerResponse queryByUserName(String name);
}
