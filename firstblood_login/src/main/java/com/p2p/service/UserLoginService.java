package com.p2p.service;

import com.fh.common.ServerResponse;
import com.p2p.model.User;

public interface UserLoginService {
    void register(User user);

    ServerResponse queryByUserPhone(String userPhone);

    ServerResponse userLogin(User user);

    ServerResponse queryByUserName(String userName);
}
