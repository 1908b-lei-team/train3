package com.p2p.service;

import com.p2p.model.User;
import com.p2p.util.ServerResponse;

public interface UserLoginService {
    void register(User user);

    ServerResponse queryByUserPhone(String userPhone);

    ServerResponse userLogin(User user);
}
