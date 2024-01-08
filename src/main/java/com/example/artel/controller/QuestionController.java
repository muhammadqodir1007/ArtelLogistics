package com.example.artel.controller;

import com.example.artel.entity.Question;
import com.example.artel.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@AllArgsConstructor
public class QuestionController {


    QuestionService questionService;

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getById(@PathVariable int id) {

        Question byId = questionService.getById(id);
        return ResponseEntity.ok(byId);

    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Question question) {
        Question insert = questionService.insert(question);
        return ResponseEntity.ok(insert);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Question question) {
        questionService.update(id, question);
        return ResponseEntity.ok("updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        questionService.deleteById(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
