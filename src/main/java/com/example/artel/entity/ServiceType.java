package com.example.artel.entity;

import jakarta.persistence.*;
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
    @Column(length = 1000)
    String description_uz;
    @Column(length = 1000)
    String description_ru;
    @Column(length = 1000)
    String description_en;
    Long imageId;
}
