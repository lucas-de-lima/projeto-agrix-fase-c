package com.betrybe.agrix.controller.dto;

import java.time.LocalDate;

/**
 * Crop Dto.
 */

public record CropBodyDto(
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate
) {}
