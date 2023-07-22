package com.penny.shoppingmall.service.impl;

import com.penny.shoppingmall.dao.UserDao;
import com.penny.shoppingmall.model.User;
import com.penny.shoppingmall.service.UserService;
import dto.UserRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

}
