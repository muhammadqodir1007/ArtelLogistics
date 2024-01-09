package com.example.artel.payload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class NewsDto {

    private String title_en;
    private String title_ru;
    private String title_uz;
    private String description_en;
    private String description_uz;
    private String description_ru;
    private MultipartFile file;

}
