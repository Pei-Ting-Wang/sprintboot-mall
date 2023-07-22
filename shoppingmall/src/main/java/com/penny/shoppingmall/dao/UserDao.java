package com.penny.shoppingmall.dao;


import com.penny.shoppingmall.model.User;
import dto.UserRegisterRequest;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
