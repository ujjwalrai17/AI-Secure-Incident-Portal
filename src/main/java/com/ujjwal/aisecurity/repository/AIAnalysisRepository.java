package com.ujjwal.aisecurity.repository;

import com.ujjwal.aisecurity.entity.AIAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIAnalysisRepository
        extends JpaRepository<AIAnalysis, Long> {

    List<AIAnalysis> findByIncidentIdOrderByAnalyzedAtDesc(Long incidentId);
}
