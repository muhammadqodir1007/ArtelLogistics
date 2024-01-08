package com.example.artel.controller;

import com.example.artel.entity.Information;
import com.example.artel.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/information")
public class InformationController {

    InformationService informationService;


    @GetMapping
    public List<Information> getAll() {

        return informationService.getAll();

    }

    @GetMapping("/{id}")
    public Information getById(@PathVariable int id) {
        return informationService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Information information) {
        Information insert = informationService.insert(information);
        return ResponseEntity.ok(insert);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Information information) {
        informationService.update(id, information);
        return ResponseEntity.ok("updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        informationService.deleteById(id);
        return ResponseEntity.ok("deleted successfully");
    }


}
