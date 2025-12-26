package com.example.activity.domain.service;

import com.example.activity.domain.model.Activity;
import com.example.activity.domain.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 领域服务（纯业务规则）
 */
@Service
public class ActivityDomainService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity getActivityById(Integer id) {
        return activityRepository.getActivityById(id);
    }
}
