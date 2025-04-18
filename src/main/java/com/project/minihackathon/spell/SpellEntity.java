package com.project.minihackathon.spell;

import com.project.minihackathon.enums.SpellDifficulty;
import com.project.minihackathon.enums.SpellType;
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

import java.util.Date;

@Entity
@Table(name = "spells")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpellEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1024)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpellDifficulty difficulty;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpellType type;

    @Column(name = "requires_wand", nullable = false)
    private boolean requiresWand;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

}
