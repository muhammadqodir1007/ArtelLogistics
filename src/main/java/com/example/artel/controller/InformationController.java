package com.example.artel.controller;

import com.example.artel.entity.Information;
import com.example.artel.image.ImageData;
import com.example.artel.image.ImageDataService;
import com.example.artel.service.InformationService;
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
@RequestMapping("/api/information")
public class InformationController {

    InformationService informationService;
    ImageDataService imageDataService;


    @GetMapping
    public List<Information> getAll() {
        return informationService.getAll();
    }

    @GetMapping("/{id}")
    public Information getById(@PathVariable int id) {
        return informationService.getById(id);
    }

    @PostMapping
    public HttpEntity<?> insert(@RequestParam("about_en") String about_en, @RequestParam("about_ru") String about_ru,
                                @RequestParam("about_uz") String about_uz, @RequestParam("email") String email,
                                @RequestParam("number") String number, @RequestParam("location") String location,
                                @RequestParam("image") MultipartFile file

    ) throws IOException {
        ImageData imageData = imageDataService.uploadImage(file);
        Information information = new Information();
        information.setAbout_en(about_en);
        information.setAbout_uz(about_uz);
        information.setAbout_ru(about_ru);
        information.setEmail(email);
        information.setLocation(location);
        information.setNumber(number);
        information.setImage(imageData.getId());

        Information insert = informationService.insert(information);
        return ResponseEntity.status(HttpStatus.CREATED).body(insert);
    }

    @PatchMapping("/{id}")
    public HttpEntity<?> update(@PathVariable int id, @RequestParam(value = "about_en", required = false) String about_en, @RequestParam(value = "about_ru", required = false) String about_ru, @RequestParam(value = "about_uz", required = false) String about_uz, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "number", required = false) String number, @RequestParam(value = "location", required = false) String location, @RequestParam(value = "image", required = false) MultipartFile file

    ) throws IOException {
        ImageData imageData = null;
        Information information = new Information();
        if (file != null) {
            imageData = imageDataService.uploadImage(file);
            information.setImage(imageData.getId());
        } else {
            information.setImage(null);
        }


        information.setAbout_en(about_en);
        information.setAbout_uz(about_uz);
        information.setAbout_ru(about_ru);
        information.setEmail(email);
        information.setLocation(location);
        information.setNumber(number);

        Information insert = informationService.insert(information);
        return ResponseEntity.status(HttpStatus.CREATED).body(insert);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        informationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted successfully");
    }


}
