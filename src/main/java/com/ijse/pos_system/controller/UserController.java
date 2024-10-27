package com.ijse.pos_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos_system.entity.User;
import com.ijse.pos_system.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
