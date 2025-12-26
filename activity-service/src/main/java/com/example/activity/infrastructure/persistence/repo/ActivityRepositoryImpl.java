package com.example.activity.infrastructure.persistence.repo;

import com.example.activity.domain.model.Activity;
import com.example.activity.domain.service.ActivityDomainService;
import com.example.activity.infrastructure.persistence.entity.ActivityEntity;
import com.example.activity.infrastructure.persistence.mapper.ActivityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ActivityRepositoryImpl implements ActivityDomainService {


    private final ActivityMapper activityMapper;

    public ActivityRepositoryImpl(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }


    @Override
    public Activity getActivityById(Integer id) {
        ActivityEntity entity = activityMapper.getActivityById(id);
        return toActivity(entity);
    }

    private Activity toActivity(ActivityEntity entity) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(entity, activity);
        return activity;
    }
}
