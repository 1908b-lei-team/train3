package com.p2p.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.p2p.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper extends BaseMapper<User> {

    User queryByUserPhone(@Param("userPhone") String userPhone);

    void register(User user);

    void updateLoginstatus(User queryByUserPhone);

    void updateLogincount(User queryByUserPhone);

    User queryByUserName(String userName);
}
