package com.example.artel.controller;

import com.example.artel.entity.ServiceType;
import com.example.artel.image.ImageData;
import com.example.artel.image.ImageDataService;
import com.example.artel.service.ServiceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/services")
public class ServiceTypeController {

    ServiceTypeService serviceTypeService;
    ImageDataService imageDataService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ServiceType> all = serviceTypeService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        ServiceType byId = serviceTypeService.getById(id);
        return ResponseEntity.ok(byId);

    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestParam("title_uz") String title_uz,
            @RequestParam("title_en") String title_en,
            @RequestParam("title_ru") String title_ru,
            @RequestParam("description_uz") String description_uz,
            @RequestParam("description_ru") String description_ru,
            @RequestParam("description_en") String description_en,
            @RequestParam("image") MultipartFile file
    ) throws IOException {

        ServiceType serviceType = new ServiceType();
        ImageData imageData = imageDataService.uploadImage(file);
        serviceType.setDescription_ru(description_ru);
        serviceType.setDescription_en(description_en);
        serviceType.setDescription_uz(description_uz);
        serviceType.setTitle_ru(title_ru);
        serviceType.setTitle_uz(title_uz);
        serviceType.setTitle_en(title_en);
        serviceType.setTitle_uz(title_uz);
        serviceType.setImageId(imageData.getId());
        System.out.println(file.getOriginalFilename());
        ServiceType insert = serviceTypeService.insert(serviceType);
        return ResponseEntity.ok(insert);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestParam(value = "title_uz", required = false) String title_uz,
                                    @RequestParam(value = "title_en", required = false) String title_en,
                                    @RequestParam(value = "title_ru", required = false) String title_ru,
                                    @RequestParam(value = "description_uz", required = false) String description_uz,
                                    @RequestParam(value = "description_ru", required = false) String description_ru,
                                    @RequestParam(value = "description_en", required = false) String description_en,
                                    @RequestParam(value = "image", required = false) MultipartFile file) throws IOException {

        ServiceType news = new ServiceType();
        if (file != null) {
            ImageData imageData = imageDataService.uploadImage(file);
            news.setImageId(imageData.getId());
        } else {
            news.setImageId(null);
        }


        news.setDescription_ru(description_ru);
        news.setDescription_en(description_en);
        news.setDescription_uz(description_uz);
        news.setTitle_ru(title_ru);
        news.setTitle_uz(title_uz);
        news.setTitle_en(title_en);
        serviceTypeService.update(id, news);
        return ResponseEntity.ok("updated successfully");


    }


}
