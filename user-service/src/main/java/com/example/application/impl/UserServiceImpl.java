package com.example.application.impl;

import com.example.application.UserService;
import com.example.controller.dto.UserResponse;
import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 应用层（协调 domain + infra）
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public UserResponse getUserById(Integer id) {
        // 简单 CRUD 操作可以直接调用 mapper
        User user = userRepository.getUserById(id);
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        return response;
    }
}
