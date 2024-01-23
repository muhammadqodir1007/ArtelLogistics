package com.example.artel.entity;

import jakarta.persistence.*;
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
    private Boolean remote;
    private String title_uz;
    private String title_ru;
    private String title_en;
    @Column(length = 1000)
    private String description_uz;
    @Column(length = 1000)
    private String description_en;
    @Column(length = 1000)
    private String description_ru;
    private String workdays;
    private String workHours;
    private String location;
    private LocalDateTime createdAt;


}
