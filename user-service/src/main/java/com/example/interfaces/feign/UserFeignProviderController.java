package com.example.interfaces.feign;

import com.example.application.UserService;
import com.example.controller.dto.GetUserRequest;
import com.example.controller.dto.UserResponse;
import com.example.controller.feign.UserFeignApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserFeignProviderController implements UserFeignApi {

    private final UserService userService;

    @Override
    @RequestMapping("getUserById")
    public UserResponse getUser(GetUserRequest request) {
        return userService.getUserById(request.getUid());
    }


}
