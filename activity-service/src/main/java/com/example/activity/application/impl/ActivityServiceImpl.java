package com.example.activity.application.impl;

import com.example.activity.application.ActivityService;
import com.example.activity.domain.model.Activity;
import com.example.activity.domain.repository.ActivityRepository;
import com.example.activity.domain.service.ActivityDomainService;
import com.example.activity.infrastructure.client.service.user.UserServiceClient;
import com.example.activity.infrastructure.client.thirdparty.alipay.trade.AlipayTradeServiceClient;
import com.example.activity.interfaces.web.dto.GetUserAndActivityInfoRequest;
import com.example.activity.interfaces.web.dto.UserAndActivityInfoResponse;
import com.example.controller.dto.GetActivityResponse;
import com.example.controller.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 应用层（协调 domain + infra）
 */
@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityDomainService activityDomainService;

    private final UserServiceClient userServiceClient;

    private final AlipayTradeServiceClient alipayTradeServiceClient;

    private final ActivityRepository activityRepository;


    @Override
    public UserAndActivityInfoResponse getUserAndActivityInfo(GetUserAndActivityInfoRequest request) {

        UserAndActivityInfoResponse response = new UserAndActivityInfoResponse();

        Activity activity = activityDomainService.getActivityById(request.getActivityId());

        UserResponse user = userServiceClient.getUser(request.getActivityId());

        //  alipayTradeServiceClient 假设需要调用外部接口

        response.setUsername(user.getName());
        response.setAge(user.getAge());
        response.setActivityId(activity.getId());
        response.setActivityName(activity.getActivityName());
        response.setActivityStartDateTime(activity.getActivityStartDateTime());
        response.setActivityEndDateTime(activity.getActivityEndDateTime());
        return response;
    }

    @Override
    public GetActivityResponse getActivityById(Integer id) {
        // 简单 CRUD 操作可以直接调用 mapper
        Activity activity = activityRepository.getActivityById(id);
        GetActivityResponse response = new GetActivityResponse();
        BeanUtils.copyProperties(activity , response);
        return response;
    }
}
