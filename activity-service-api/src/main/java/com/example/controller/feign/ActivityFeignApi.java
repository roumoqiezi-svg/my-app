package com.example.controller.feign;

import com.example.controller.dto.GetActivityRequest;
import com.example.controller.dto.GetActivityResponse;

public interface ActivityFeignApi {
    GetActivityResponse getActivity(GetActivityRequest request);
}
