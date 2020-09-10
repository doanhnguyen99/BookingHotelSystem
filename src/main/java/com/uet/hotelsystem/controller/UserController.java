package com.uet.hotelsystem.controller;

import com.uet.hotelsystem.model.UserEntity;
import com.uet.hotelsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return userService.getAllUser();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserEntity userEntity) {
        userService.addUser(userEntity);
    }

}
