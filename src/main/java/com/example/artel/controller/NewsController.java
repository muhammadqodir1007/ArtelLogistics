package com.example.artel.controller;

import com.example.artel.entity.News;
import com.example.artel.image.ImageData;
import com.example.artel.image.ImageDataService;
import com.example.artel.image.ImageUtil;
import com.example.artel.payload.NewsDto;
import com.example.artel.payload.response.NewsResponse;
import com.example.artel.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@AllArgsConstructor
public class NewsController {

    NewsService newsService;
    ImageDataService imageDataService;


//    @GetMapping
//    public ResponseEntity<?> getAll() {
//        List<News> all = newsService.getAll();
//        List<NewsResponse> responses = new ArrayList<>();
//
//        for (News news : all) {
//            ImageData imageData = news.getImageData();
//            byte[] image = ImageUtil.decompressImage(imageData.getImageData());
//            NewsResponse newsResponse = new NewsResponse();
//            newsResponse.setFile(image);
//            newsResponse.setDescription_ru(news.getDescription_ru());
//            newsResponse.setDescription_uz(news.getDescription_uz());
//            newsResponse.setDescription_en(news.getDescription_en());
//            newsResponse.setTitle_ru(news.getTitle_ru());
//            newsResponse.setTitle_uz(news.getTitle_uz());
//            newsResponse.setTitle_en(news.getTitle_en());
//            newsResponse.setId(news.getId());
//            responses.add(newsResponse);
//        }
//        return ResponseEntity.ok(responses);
//    }


//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable int id) {
//        News news = newsService.getById(id);
//        ImageData imageData = news.getImageData();
//        byte[] image = ImageUtil.decompressImage(imageData.getImageData());
//        NewsResponse newsResponse = new NewsResponse();
//        newsResponse.setFile(image);
//        newsResponse.setDescription_ru(news.getDescription_ru());
//        newsResponse.setDescription_uz(news.getDescription_uz());
//        newsResponse.setDescription_en(news.getDescription_en());
//        newsResponse.setTitle_ru(news.getTitle_ru());
//        newsResponse.setTitle_uz(news.getTitle_uz());
//        newsResponse.setTitle_en(news.getTitle_en());
//        newsResponse.setId(news.getId());
//        return ResponseEntity.ok(newsResponse);
//
//
//    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestParam("title_uz") String title_uz,
                                    @RequestParam("title_en") String title_en,
                                    @RequestParam("title_ru") String title_ru,
                                    @RequestParam("description_uz") String description_uz,
                                    @RequestParam("description_ru") String description_ru,
                                    @RequestParam("description_en") String description_en,
                                    @RequestParam("image") MultipartFile file) throws IOException {
        NewsDto news = new NewsDto();
        news.setFile(file);
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

        NewsDto news = new NewsDto();
        news.setFile(file);
        news.setDescription_ru(description_ru);
        news.setDescription_en(description_en);
        news.setDescription_uz(description_uz);
        news.setTitle_ru(title_ru);
        news.setTitle_uz(title_uz);
        news.setTitle_en(title_en);
        News insert = newsService.insert(news);
        return ResponseEntity.ok(insert);

    }


}
