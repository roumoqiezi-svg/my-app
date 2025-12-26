package com.example.activity.interfaces.feign;

import com.example.activity.application.ActivityService;
import com.example.controller.dto.GetActivityRequest;
import com.example.controller.dto.GetActivityResponse;
import com.example.controller.feign.ActivityFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
public class ActivityFeignProviderController implements ActivityFeignApi {


    @Autowired
    private ActivityService activityService;


    @Override
    @PostMapping("/getActivity")
    public GetActivityResponse getActivity(GetActivityRequest request) {
        return activityService.getActivityById(request.getActivityId());
    }
}
