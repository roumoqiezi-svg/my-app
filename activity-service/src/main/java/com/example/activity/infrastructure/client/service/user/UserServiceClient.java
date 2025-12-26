package com.example.activity.infrastructure.client.service.user;


import com.example.controller.dto.GetUserRequest;
import com.example.controller.dto.UserResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceClient {

    @Resource
    private UserApiClient feignClient;

    public UserResponse getUser(Integer userId) {
        try {
            return feignClient.getUser(new GetUserRequest(userId));
        } catch (FeignException e) {
            log.error("调用 user-service 失败", e);
            throw new RuntimeException("用户服务不可用");
        }
    }
}
