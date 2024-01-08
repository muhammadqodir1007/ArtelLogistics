package com.example.artel.payload;

import lombok.Data;

@Data
public class ApiResponse {

    boolean success;
    String message;
    Object object;


    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
