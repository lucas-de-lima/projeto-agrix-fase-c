package com.betrybe.agrix.services;

import com.betrybe.agrix.exeptions.FertilizersNotFoundExeption;
import com.betrybe.agrix.models.entities.Fertilizers;
import com.betrybe.agrix.models.repositories.FertilizersRepositories;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FertilizerService.
 */
@Service
public class FertilizerService {
  private FertilizersRepositories fertilizersRepositories;

  @Autowired
  public FertilizerService(FertilizersRepositories fertilizersRepositories) {
    this.fertilizersRepositories = fertilizersRepositories;
  }

  /**
   * Insert fertilizer.
   */
  public Fertilizers insertFertilizer(Fertilizers fertilizer) {
    return fertilizersRepositories.save(fertilizer);
  }

  /**
   * Get all fertilizers.
   */
  public List<Fertilizers> getAllFertilizers() {
    return fertilizersRepositories.findAll();
  }

  /**
   * Get fertilizer by id.
   */
  public Fertilizers getFertilizersById(Long id) {
    Optional<Fertilizers> fertilizer = fertilizersRepositories.findById(id);
    if (fertilizer.isEmpty()) {
      throw new FertilizersNotFoundExeption();
    }
    return fertilizer.get();
  }

}
