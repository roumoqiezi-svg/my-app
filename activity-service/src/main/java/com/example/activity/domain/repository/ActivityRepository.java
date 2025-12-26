package com.example.activity.domain.repository;

import com.example.activity.domain.model.Activity;

public interface ActivityRepository {
    Activity getActivityById(Integer id);
}
