package com.fh.service;

import com.fh.model.User;
import com.fh.common.ServerResponse;

public interface UserService {
    User queryStatus(Integer id);

    void updStatus(User user);
}
