package com.penny.shoppingmall.service.impl;

import com.penny.shoppingmall.dao.UserDao;
import com.penny.shoppingmall.model.User;
import com.penny.shoppingmall.service.UserService;
import dto.UserRegisterRequest;
import org.apache.coyote.Response;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user=userDao.getUserByEmail(userRegisterRequest.getEmail());
        if(user!=null){
            log.warn("該email {} 已被註冊",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

}
