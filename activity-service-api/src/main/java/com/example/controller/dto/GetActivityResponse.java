package com.example.controller.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetActivityResponse {
    private Integer id;
    private Integer uid;
    private String activityName;
    private LocalDateTime activityStartDateTime;
    private LocalDateTime activityEndDateTime;

}
