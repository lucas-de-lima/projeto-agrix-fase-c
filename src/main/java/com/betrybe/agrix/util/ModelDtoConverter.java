package com.betrybe.agrix.util;

import com.betrybe.agrix.controller.dto.CropBodyDto;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmBodyDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.controller.dto.FertilizerBodyDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Crops;
import com.betrybe.agrix.models.entities.Farms;
import com.betrybe.agrix.models.entities.Fertilizers;

/**
 * ModelDtoConverter.
 */

public class ModelDtoConverter {
  /**
   * Convert from dto to model.
   */
  
  public static Farms dtoToModel(FarmBodyDto dto) {
    Farms farm = new Farms();

    farm.setName(dto.name());
    farm.setSize(dto.size());
    
    return farm;
  }

  /**
   * Convert from model to dto.
   */

  public static FarmDto modelToDto(Farms farm) {
    return new FarmDto(
      farm.getId(),
      farm.getName(),
      farm.getSize()
    );
  }

  /**
   * Convert from dto to model.
   */

  public static Crops dtoToCrops(CropBodyDto dto) {
    Crops crop = new Crops();

    crop.setName(dto.name());
    crop.setPlantedArea(dto.plantedArea());
    crop.setPlantedDate(dto.plantedDate());
    crop.setHarvestDate(dto.harvestDate());
    return crop;
  }

  /**
   * Convert from model to dto.
   */

  public static CropDto cropToDto(Crops crop) {
    return new CropDto(
      crop.getId(),
      crop.getName(),
      crop.getPlantedArea(),
      crop.getFarm().getId(),
      crop.getPlantedDate(),
      crop.getHarvestDate()
    );
  }

  /**
   * Convert from dto to model.
   */

  public static Fertilizers dtoToFertilizers(FertilizerBodyDto dto) {
    Fertilizers fertilizer = new Fertilizers();
    fertilizer.setName(dto.name());
    fertilizer.setBrand(dto.brand());
    fertilizer.setComposition(dto.composition());
    return fertilizer;
  }

  /**
   * Convert from model to dto.
   */

  public static FertilizerDto fertilizerToDto(Fertilizers fertilizer) {
    return new FertilizerDto(
      fertilizer.getId(),
      fertilizer.getName(),
      fertilizer.getBrand(),
      fertilizer.getComposition()
    );
  }

}
