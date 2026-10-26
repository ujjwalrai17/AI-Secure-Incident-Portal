
package com.ujjwal.aisecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_analyses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "incident_id", nullable = false)
    private Incident incident;

    @Column(nullable = false)
    private String suspectedThreatType;

    @Column(nullable = false, length = 20)
    private String riskLevel;

    @Column(nullable = false, length = 2000)
    private String explanation;

    @Lob
    @Column(nullable = false)
    private String recommendedActions;

    @Column(nullable = false)
    private LocalDateTime analyzedAt;
}
