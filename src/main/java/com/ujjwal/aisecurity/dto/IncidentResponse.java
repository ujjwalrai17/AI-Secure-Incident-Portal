package com.ujjwal.aisecurity.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncidentResponse {

    private Long id;
    private String title;
    private String description;
    private String severity;
    private String status;
    private String createdBy;
    private LocalDateTime createdAt;
}