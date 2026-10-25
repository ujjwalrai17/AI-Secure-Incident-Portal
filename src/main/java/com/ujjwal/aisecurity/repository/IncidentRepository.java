package com.ujjwal.aisecurity.repository;

import com.ujjwal.aisecurity.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}