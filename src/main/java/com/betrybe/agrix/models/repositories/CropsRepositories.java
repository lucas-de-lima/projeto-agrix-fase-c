package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crops;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CropsRepositories.
 */

public interface CropsRepositories extends JpaRepository<Crops, Long> {
    
  /**
   * findByHarvestDateBetween. 
   * função do hibernate que busca por uma data de colheita entre duas datas
   */
  List<Crops> findByHarvestDateBetween(LocalDate start, LocalDate end);
}
