package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Fertilizers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FertilizersRepositories.
 */
public interface FertilizersRepositories extends JpaRepository<Fertilizers, Long> {}
