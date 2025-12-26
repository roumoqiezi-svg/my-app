package com.example.activity.infrastructure.client.service.user;

import com.example.controller.dto.GetUserRequest;
import com.example.controller.dto.UserResponse;
import com.example.controller.feign.UserFeignApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service" , url = "http://127.0.0.1:8082/user")
public interface UserApiClient extends UserFeignApi {
    @Override
    @RequestMapping("/getUserById")
    UserResponse getUser(GetUserRequest request);
}
