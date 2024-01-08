package com.example.artel.controller;

import com.example.artel.entity.News;
import com.example.artel.service.NewsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@AllArgsConstructor
public class NewsController {

    NewsService newsService;


    @GetMapping
    public List<News> getAll() {
        return newsService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        News news = newsService.getById(id);
        return ResponseEntity.ok(news);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody News news) {
        newsService.update(id, news);
        return ResponseEntity.ok("updated successfully");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        newsService.deleteById(id);
        return ResponseEntity.ok("deleted successfully");
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody News news) {

        News insert = newsService.insert(news);
        return ResponseEntity.ok(insert);

    }


}
