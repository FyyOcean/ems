package com.baizhi.ems.service;

import com.baizhi.ems.dao.UserDAO;
import com.baizhi.ems.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        System.out.println(user);
        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {

        return userDAO.findByUsernameAndPassword(username,password);
    }
}
