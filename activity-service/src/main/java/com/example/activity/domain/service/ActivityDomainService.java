package com.example.activity.domain.service;

import com.example.activity.domain.model.Activity;

/**
 * 领域服务（纯业务规则）
 */
public interface ActivityDomainService {

    Activity getActivityById(Integer id);
}
