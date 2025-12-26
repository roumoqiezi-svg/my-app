package com.example.domain.repository;

import com.example.domain.model.User;

public interface UserRepository {
    User getUserById(Integer id);
}
