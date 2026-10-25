//package com.ujjwal.aisecurity.dto;
//
//import lombok.Data;
//
//@Data
//public class IncidentRequest {
//
//    private String title;
//
//    private String description;
//
//    private String severity;
//}



package com.ujjwal.aisecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IncidentRequest {

    @NotBlank(message = "Incident title is required")
    @Size(max = 150, message = "Title cannot exceed 150 characters")
    private String title;

    @NotBlank(message = "Incident description is required")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @NotBlank(message = "Severity is required")
    @Pattern(
            regexp = "(?i)LOW|MEDIUM|HIGH|CRITICAL",
            message = "Severity must be LOW, MEDIUM, HIGH, or CRITICAL"
    )
    private String severity;
}
