package com.example.artel.controller;

import com.example.artel.service.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/home")
@AllArgsConstructor
public class HomeController {
    HomeService homeService;


    @GetMapping
    public ResponseEntity<?> getMap() {
        Map<String, Long> count =
                homeService.count();
        return ResponseEntity.ok(count);

    }


}
