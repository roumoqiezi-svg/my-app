package com.example.activity.infrastructure.persistence.mapper;

import com.example.activity.infrastructure.persistence.entity.ActivityEntity;
import org.springframework.stereotype.Component;

@Component
public interface ActivityMapper {
    ActivityEntity getActivityById(Integer id);
}
