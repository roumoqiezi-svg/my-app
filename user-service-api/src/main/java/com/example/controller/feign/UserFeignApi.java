package com.example.controller.feign;

import com.example.controller.dto.GetUserRequest;
import com.example.controller.dto.UserResponse;

public interface UserFeignApi {
    UserResponse getUser(GetUserRequest request);
}
