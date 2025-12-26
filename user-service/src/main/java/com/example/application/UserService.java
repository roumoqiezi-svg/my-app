package com.example.application;

import com.example.controller.dto.UserResponse;

public interface UserService {

    UserResponse getUserById(Integer id);
}
