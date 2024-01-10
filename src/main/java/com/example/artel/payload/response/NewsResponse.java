package com.example.artel.payload.response;

import lombok.Data;

@Data
public class NewsResponse {
    private int id;
    private String title_en;
    private String title_ru;
    private String title_uz;
    private String description_en;
    private String description_uz;
    private String description_ru;
    private byte[] file;


}
