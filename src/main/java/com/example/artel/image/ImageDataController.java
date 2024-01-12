package com.example.artel.image;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/image")
public class ImageDataController {

    private ImageDataService imageDataService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        ImageData data = imageDataService.uploadImage(file);

        return ResponseEntity.status(HttpStatus.OK)
                .body(data.getName());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getImageInfoById(@PathVariable Long id) {
        ImageData image = imageDataService.getInfoByImageById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageByName(@PathVariable Long id) {
        byte[] image = imageDataService.getImage(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}