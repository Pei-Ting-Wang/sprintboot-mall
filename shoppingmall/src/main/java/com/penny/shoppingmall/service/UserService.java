package com.penny.shoppingmall.service;

import com.penny.shoppingmall.model.User;
import com.penny.shoppingmall.dto.UserLoginRequest;
import com.penny.shoppingmall.dto.UserRegisterRequest;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);

}
