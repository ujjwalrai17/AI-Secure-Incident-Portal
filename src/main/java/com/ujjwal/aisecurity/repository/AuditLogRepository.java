package com.ujjwal.aisecurity.repository;

import com.ujjwal.aisecurity.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}