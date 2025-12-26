package com.example.interfaces.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAndActivityInfoResponse {
    private String username;
    private Integer age;
    private Integer activityId;
    private String activityName;
    private LocalDateTime activityStartDateTime;
    private LocalDateTime activityEndDateTime;
}
