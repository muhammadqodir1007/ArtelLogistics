package com.example.artel.controller;

import com.example.artel.entity.Hiring;
import com.example.artel.service.HiringService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/hiring")
@AllArgsConstructor
public class HiringController {


    HiringService hiringService;

    @GetMapping
    public List<Hiring> getAll() {
        return hiringService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Hiring byId = hiringService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Hiring hiring) throws IOException {
        Hiring insert = hiringService.insert(hiring);
        return ResponseEntity.ok(insert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        hiringService.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Hiring hiring) throws IOException {

        hiringService.update(id, hiring);
        return ResponseEntity.ok("updated Successfully");

    }

}
