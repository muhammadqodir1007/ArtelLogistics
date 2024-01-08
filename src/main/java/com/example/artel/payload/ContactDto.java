package com.example.artel.payload;

import lombok.Data;

@Data
public class ContactDto {
    String firstName;
    String secondName;
    String number;
    String email;
    String message;
}
