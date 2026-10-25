
package com.ujjwal.aisecurity.controller;

import com.ujjwal.aisecurity.dto.IncidentRequest;
import com.ujjwal.aisecurity.dto.IncidentResponse;
import com.ujjwal.aisecurity.service.IncidentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public IncidentResponse create(
            @Valid @RequestBody IncidentRequest request) {

        return service.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST', 'MANAGER')")
    public List<IncidentResponse> getAll() {
        return service.getAll();
    }
}
