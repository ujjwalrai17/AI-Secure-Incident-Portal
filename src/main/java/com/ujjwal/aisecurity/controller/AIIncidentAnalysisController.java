
package com.ujjwal.aisecurity.controller;

import com.ujjwal.aisecurity.dto.AIAnalysisHistoryResponse;
import com.ujjwal.aisecurity.dto.AIAnalysisRequest;
import com.ujjwal.aisecurity.dto.AIAnalysisResponse;
import com.ujjwal.aisecurity.service.AIIncidentAnalysisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIIncidentAnalysisController {

    private final AIIncidentAnalysisService analysisService;

    // Existing endpoint: analyzes a supplied description.
    @PostMapping("/analyze")
    public AIAnalysisResponse analyze(
            @Valid @RequestBody AIAnalysisRequest request) {

        return analysisService.analyzeIncident(
                request.getDescription()
        );
    }

    // New endpoint: analyzes and saves an existing incident.
    @PostMapping("/incidents/{incidentId}/analyze")
    public AIAnalysisResponse analyzeAndSave(
            @PathVariable Long incidentId) {

        return analysisService.analyzeAndSave(incidentId);
    }

    @GetMapping("/incidents/{incidentId}/history")
    public List<AIAnalysisHistoryResponse> getAnalysisHistory(
            @PathVariable Long incidentId) {

        return analysisService.getAnalysisHistory(incidentId);
    }
}
