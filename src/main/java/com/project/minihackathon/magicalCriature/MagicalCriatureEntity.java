package com.project.minihackathon.magicalCriature;

import com.project.minihackathon.enums.CreatureHabit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
  @Table(name = "magical_creatures")
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public class MagicalCriatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String species;

    @Column(length = 512)
    private String description;

    @Column(name = "danger_level", nullable = false)
    private int dangerLevel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CreatureHabit habitat;

    @Column(name = "is_domesticated", nullable = false)
    private boolean isDomesticated;

    @Column(name = "discovered_date", nullable = false)
    private LocalDate discoveredDate;
  }

