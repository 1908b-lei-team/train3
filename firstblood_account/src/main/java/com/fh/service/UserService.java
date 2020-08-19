package com.fh.service;

import com.fh.model.User;
import com.fh.util.ServerResponse;

public interface UserService {
    User queryStatus(Integer id);

    void updStatus(User user);
}
