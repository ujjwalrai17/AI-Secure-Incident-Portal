package com.ujjwal.aisecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIAnalysisResponse {

    private String suspectedThreatType;

    private String riskLevel;

    private String explanation;

    private List<String> recommendedActions;
}
