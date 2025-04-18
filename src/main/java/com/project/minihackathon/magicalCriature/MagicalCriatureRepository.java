package com.project.minihackathon.magicalCriature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicalCriatureRepository extends JpaRepository<MagicalCriatureEntity, Integer> {
}