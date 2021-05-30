package com.example.ztpai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {
    private Long projectId;
    private String name;
    private String description;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
