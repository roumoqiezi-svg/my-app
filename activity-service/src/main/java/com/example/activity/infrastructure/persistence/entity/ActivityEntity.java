package com.example.activity.infrastructure.persistence.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityEntity {
    private Integer id;
    private Integer uid;
    private String activityName;
    private LocalDateTime activityStartDateTime;
    private LocalDateTime activityEndDateTime;

}
