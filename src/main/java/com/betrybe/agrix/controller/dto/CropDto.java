package com.betrybe.agrix.controller.dto;

import java.time.LocalDate;

/**
 * Crop Dto.
 */

public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId,
    LocalDate plantedDate,
    LocalDate harvestDate
) {}
