package com.example.artel.controller;

import com.example.artel.entity.Banner;
import com.example.artel.image.ImageData;
import com.example.artel.image.ImageDataService;
import com.example.artel.service.BannerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/banner")
public class BannerController {

    BannerService bannerService;
    ImageDataService imageDataService;


    @GetMapping
    public HttpEntity<?> getAll() {
        List<Banner> all =
                bannerService.getAll();
        return ResponseEntity.ok(all);

    }


    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable int id) {
        Banner byId = bannerService.getById(id);
        return ResponseEntity.ok(byId);

    }

    @PostMapping
    public HttpEntity<?> insert(@RequestParam("image") MultipartFile file) throws IOException {
        ImageData imageData = imageDataService.uploadImage(file);
        Banner banner = new Banner();
        banner.setImage(imageData.getId());
        Banner insert = bannerService.insert(banner);
        return ResponseEntity.status(HttpStatus.CREATED).body(insert);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable int id) {
        bannerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted");
    }
}
