
package com.ujjwal.aisecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AIAnalysisRequest {

    @NotBlank(message = "Incident description is required")
    @Size(max = 4000, message = "Description cannot exceed 4000 characters")
    private String description;
}
