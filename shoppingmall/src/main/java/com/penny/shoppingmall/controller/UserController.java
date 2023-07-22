package com.penny.shoppingmall.controller;

import com.penny.shoppingmall.model.User;
import com.penny.shoppingmall.service.UserService;
import dto.UserRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(
            @RequestBody @Valid UserRegisterRequest userRegisterRequest
            ){
        Integer userId=userService.register(userRegisterRequest);
        User user=userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}