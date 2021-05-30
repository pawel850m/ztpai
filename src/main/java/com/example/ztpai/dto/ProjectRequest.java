package com.example.ztpai.dto;

import lombok.Data;

@Data
public class ProjectRequest {
    private Long projectId;
    private String name;
    private String description;
    private String status;
}
