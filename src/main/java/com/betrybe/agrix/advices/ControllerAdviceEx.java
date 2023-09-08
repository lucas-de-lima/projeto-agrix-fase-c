package com.betrybe.agrix.advices;

import com.betrybe.agrix.exeptions.CropNotFoundExeption;
import com.betrybe.agrix.exeptions.FarmNotFoundExeption;
import com.betrybe.agrix.exeptions.FertilizersNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ControllerAdvice.
 */

@ControllerAdvice
public class ControllerAdviceEx {
  
  @ExceptionHandler(FarmNotFoundExeption.class)
  public ResponseEntity<String> handleInvalidFarmException() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
  }

  @ExceptionHandler(CropNotFoundExeption.class)
  public ResponseEntity<String> handleInvalidCropException() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plantação não encontrada!");
  }

  @ExceptionHandler(FertilizersNotFoundExeption.class)
  public ResponseEntity<String> handleInvalidFertilizerException() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fertilizante não encontrado!");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException() {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}
