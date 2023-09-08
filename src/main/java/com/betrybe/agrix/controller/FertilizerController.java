package com.betrybe.agrix.controller;


import com.betrybe.agrix.controller.dto.FertilizerBodyDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Crops;
import com.betrybe.agrix.models.entities.Fertilizers;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FertilizerService;
import com.betrybe.agrix.util.ModelDtoConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



/**
 * FertilizerController.
 */
@RestController
public class FertilizerController {
  private final FertilizerService fertilizerService;
  private final CropService cropService;
  
  @Autowired
  public FertilizerController(FertilizerService fertilizerService, CropService cropService) {
    this.fertilizerService = fertilizerService;
    this.cropService = cropService;
  }

  /**
   * Insert fertilizer.
   */
  @PostMapping("/fertilizers")
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto insertFertilizer(@RequestBody FertilizerBodyDto fertilizerDto) {
    Fertilizers fertilizer = ModelDtoConverter.dtoToFertilizers(fertilizerDto);
    Fertilizers response = fertilizerService.insertFertilizer(fertilizer);
    return ModelDtoConverter.fertilizerToDto(response);
  }

  /**
   * Get all fertilizers.
   */
  @GetMapping("/fertilizers")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getAllFertilizer() {
    List<Fertilizers> fertilizers = fertilizerService.getAllFertilizers();
    return fertilizers.stream().map(ModelDtoConverter::fertilizerToDto).toList();
  }

  /**
   * Get fertilizer by id.
   */
  @GetMapping("/fertilizers/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FertilizerDto getFertilizerById(@PathVariable(name = "id") long id) {
    Fertilizers fertilizer = fertilizerService.getFertilizersById(id);
    return ModelDtoConverter.fertilizerToDto(fertilizer);
  }

  /**
   * Insert fertilizer in crop.
   */
  @PostMapping("/crops/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String insertFertilizerInCrop(@PathVariable(name = "cropId") long cropId,
      @PathVariable(name = "fertilizerId") long fertilizerId) {
    Crops crop = cropService.getCropById(cropId);
    Fertilizers fertilizer = fertilizerService.getFertilizersById(fertilizerId);
    crop.addFertilizer(fertilizer);
    cropService.recordCrop(crop);
    return "Fertilizante e plantação associados com sucesso!";
  }
}
