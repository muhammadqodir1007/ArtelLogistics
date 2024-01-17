package com.example.artel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String title_uz;
    String title_ru;
    String title_en;
    String description_uz;
    String description_ru;
    String description_en;
    Long imageId;
}
