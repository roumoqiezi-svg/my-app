package com.example.infrastructure.persistence.mapper;

import com.example.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    UserEntity getUserById(Integer id);
}
