package com.example.infrastructure.persistence;

import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;
import com.example.infrastructure.persistence.entity.UserEntity;
import com.example.infrastructure.persistence.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        UserEntity entity = userMapper.getUserById(id);
        return mapToDomain(entity);
    }

    private User mapToDomain(UserEntity entity) {
        User user = new User();
        BeanUtils.copyProperties(entity , user);
        return user;
    }

}
