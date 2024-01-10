package com.example.artel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private boolean remote;
    private String title_uz;
    private String title_ru;
    private String title_en;
    private String description_uz;
    private String description_en;
    private String description_ru;
    private String workdays;
    private String workHours;
    private String location;
    private LocalDateTime createdAt;


}
