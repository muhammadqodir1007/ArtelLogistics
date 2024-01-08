package com.example.artel.controller;

import com.example.artel.entity.Vacancy;
import com.example.artel.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancy")
@AllArgsConstructor
public class VacancyController {


    VacancyService vacancyService;


    @GetMapping
    public List<Vacancy> getAll() {
        return vacancyService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Vacancy byId = vacancyService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Vacancy vacancy) {
        Vacancy insert = vacancyService.insert(vacancy);
        return ResponseEntity.ok(insert);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        vacancyService.deleteById(id);
        return ResponseEntity.ok("deleted successfully");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Vacancy vacancy) {
        vacancyService.update(id, vacancy);
        return ResponseEntity.ok("updated successfully");
    }


}
