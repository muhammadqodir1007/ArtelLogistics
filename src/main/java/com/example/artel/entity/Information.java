package com.example.artel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(length = 1000)
    String about_en;
    @Column(length = 1000)
    String about_ru;
    @Column(length = 1000)
    String about_uz;
    String email;
    String number;
    @Column(length = 1000)
    String location;
    Long image;
}
