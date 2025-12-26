package com.example.activity.application;

import com.example.activity.interfaces.web.dto.GetUserAndActivityInfoRequest;
import com.example.activity.interfaces.web.dto.UserAndActivityInfoResponse;
import com.example.controller.dto.GetActivityResponse;

public interface ActivityService {
    UserAndActivityInfoResponse getUserAndActivityInfo(GetUserAndActivityInfoRequest request);

    GetActivityResponse getActivityById(Integer id);
}
