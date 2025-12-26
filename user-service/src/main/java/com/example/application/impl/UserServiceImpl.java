package com.example.application.impl;

import com.example.application.UserService;
import com.example.controller.dto.UserResponse;
import com.example.infrastructure.persistence.entity.UserEntity;
import com.example.infrastructure.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 应用层（协调 domain + infra）
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;

    @Override
    public UserResponse getUserById(Integer id) {
        // 简单 CRUD 操作可以直接调用 mapper
        UserEntity entity = userMapper.getUserById(id);
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
