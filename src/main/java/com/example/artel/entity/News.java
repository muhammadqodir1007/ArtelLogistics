package com.example.artel.entity;

import com.example.artel.image.ImageData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title_en;
    private String title_ru;
    private String title_uz;
    private String description_en;
    private String description_uz;
    private String description_ru;
    private LocalDateTime createdDate;
//    private byte [] blob;

    @OneToOne
    private ImageData imageData;

}
