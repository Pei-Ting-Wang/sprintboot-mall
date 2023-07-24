package com.penny.shoppingmall.dao;


import com.penny.shoppingmall.model.User;
import com.penny.shoppingmall.dto.UserRegisterRequest;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);


    User getUserByEmail(String email);
}
