package com.penny.shoppingmall.service;

import com.penny.shoppingmall.model.User;
import dto.UserLoginRequest;
import dto.UserRegisterRequest;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);

}
