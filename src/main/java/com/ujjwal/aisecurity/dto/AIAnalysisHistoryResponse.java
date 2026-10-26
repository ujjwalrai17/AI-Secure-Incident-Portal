package com.ujjwal.aisecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIAnalysisHistoryResponse {

    private Long id;
    private Long incidentId;
    private String suspectedThreatType;
    private String riskLevel;
    private String explanation;
    private List<String> recommendedActions;
    private LocalDateTime analyzedAt;
}