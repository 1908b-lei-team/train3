package com.fh.service.login;

import com.fh.common.ServerResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {
    @Override
    public ServerResponse queryByUserName(String name) {
        return ServerResponse.errorMethod();
    }
}
