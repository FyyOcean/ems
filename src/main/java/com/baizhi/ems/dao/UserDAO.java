package com.baizhi.ems.dao;

import com.baizhi.ems.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    //保存用户
    void save(User user);

    //用户登录
    User findByUsernameAndPassword(@Param("username") String username, @Param("password")String password);
}
