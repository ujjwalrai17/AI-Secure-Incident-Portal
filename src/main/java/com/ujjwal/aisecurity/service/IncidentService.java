package com.ujjwal.aisecurity.service;

import com.ujjwal.aisecurity.dto.IncidentRequest;
import com.ujjwal.aisecurity.dto.IncidentResponse;
import com.ujjwal.aisecurity.entity.Incident;
import com.ujjwal.aisecurity.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository repository;
    private final AuditLogService auditLogService;

    public IncidentResponse create(IncidentRequest request) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Incident incident = Incident.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .severity(request.getSeverity())
                .status("OPEN")
                .createdBy(username)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(incident);

        auditLogService.log(username, "Created Incident");

        return map(incident);
    }

    public List<IncidentResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private IncidentResponse map(Incident incident) {

        return IncidentResponse.builder()
                .id(incident.getId())
                .title(incident.getTitle())
                .description(incident.getDescription())
                .severity(incident.getSeverity())
                .status(incident.getStatus())
                .createdBy(incident.getCreatedBy())
                .createdAt(incident.getCreatedAt())
                .build();
    }
}