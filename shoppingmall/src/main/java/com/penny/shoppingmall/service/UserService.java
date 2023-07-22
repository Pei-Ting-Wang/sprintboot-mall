package com.penny.shoppingmall.service;

import com.penny.shoppingmall.model.User;
import dto.UserRegisterRequest;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);


}
