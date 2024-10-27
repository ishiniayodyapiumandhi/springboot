package com.ijse.pos_system.service;

import org.springframework.stereotype.Service;

import com.ijse.pos_system.entity.User;

@Service
public interface UserService {
    User createUser(User user);
}
