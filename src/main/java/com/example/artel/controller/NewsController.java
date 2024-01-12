package com.example.artel.controller;

import com.example.artel.entity.News;
import com.example.artel.image.ImageData;
import com.example.artel.image.ImageDataService;
import com.example.artel.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@AllArgsConstructor
public class NewsController {

    NewsService newsService;
    ImageDataService imageDataService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<News> all = newsService.getAll();
        return ResponseEntity.ok(all);

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        News news = newsService.getById(id);
        return ResponseEntity.ok(news);


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
        News news = new News();
        if (file != null) {
            ImageData imageData = imageDataService.uploadImage(file);
            news.setJpgId(imageData.getId());
        } else {
            news.setJpgId(null);
        }


        news.setDescription_ru(description_ru);
        news.setDescription_en(description_en);
        news.setDescription_uz(description_uz);
        news.setTitle_ru(title_ru);
        news.setTitle_uz(title_uz);
        news.setTitle_en(title_en);
        newsService.update(id, news);
        return ResponseEntity.ok("updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        newsService.deleteById(id);
        return ResponseEntity.ok("deleted successfully");
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

        News news = new News();
        ImageData imageData = imageDataService.uploadImage(file);
        news.setDescription_ru(description_ru);
        news.setDescription_en(description_en);
        news.setDescription_uz(description_uz);
        news.setTitle_ru(title_ru);
        news.setTitle_uz(title_uz);
        news.setTitle_en(title_en);
        news.setTitle_uz(title_uz);
        news.setJpgId(imageData.getId());
        System.out.println(file.getOriginalFilename());
        News insert = newsService.insert(news);
        return ResponseEntity.ok(insert);

    }


}
