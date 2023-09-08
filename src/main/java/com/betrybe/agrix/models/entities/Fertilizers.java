package com.betrybe.agrix.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Fertilizers.
 */
@Entity
@Table(name = "fertilizer")
public class Fertilizers {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String brand;
  private String composition;

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "fertilizer_id"),
      inverseJoinColumns = @JoinColumn(name = "crop_id")
  )
  private List<Crops> crops = new ArrayList<>();

  /**
   * Fertilizers.
   */
  public Fertilizers(Long id, String name, String brand, String composition, List<Crops> crops) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
    this.crops = crops;
  }

  public Fertilizers() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }

  public List<Crops> getCrops() {
    return crops;
  }

  public void setCrops(List<Crops> crops) {
    this.crops = crops;
  }
}
