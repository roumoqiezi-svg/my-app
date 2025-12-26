package com.example.activity.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Activity {
    private Integer id;
    private Integer uid;
    private String activityName;
    private LocalDateTime activityStartDateTime;
    private LocalDateTime activityEndDateTime;
}
