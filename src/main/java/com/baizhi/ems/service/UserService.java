package com.baizhi.ems.service;

import com.baizhi.ems.entity.User;

public interface UserService {
    //保存用户
    void save(User user);
    User login(String username ,String password);
}
