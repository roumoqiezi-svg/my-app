package com.example.activity.interfaces.web.controller;


import com.example.activity.application.ActivityService;
import com.example.activity.interfaces.web.dto.GetUserAndActivityInfoRequest;
import com.example.activity.interfaces.web.dto.UserAndActivityInfoResponse;
import com.example.controller.dto.GetActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    /**
     * 查询用户信息已经关联活动
     */
    @PostMapping("/getUserAndActivityInfo")
    public UserAndActivityInfoResponse getUserAndActivityInfo(@RequestBody GetUserAndActivityInfoRequest request) {
        return activityService.getUserAndActivityInfo(request);
    }


    /**
     * 简单查询
     */
    @PostMapping("/getActivityById")
    public GetActivityResponse getActivityById(@RequestBody GetUserAndActivityInfoRequest request) {
        return activityService.getActivityById(request.getActivityId());
    }


}
