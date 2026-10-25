package com.ujjwal.aisecurity.service;

import com.ujjwal.aisecurity.entity.AuditLog;
import com.ujjwal.aisecurity.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository repository;

    public void log(String username, String action) {

        AuditLog log = AuditLog.builder()
                .username(username)
                .action(action)
                .timestamp(LocalDateTime.now())
                .build();

        repository.save(log);
    }
}