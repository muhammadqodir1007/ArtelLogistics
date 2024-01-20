package com.example.artel.controller;

import com.example.artel.entity.Testimony;
import com.example.artel.image.ImageData;
import com.example.artel.image.ImageDataService;
import com.example.artel.service.TestimonyService;
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
@RequestMapping("/api/testimony")
public class TestimonyController {
    ImageDataService imageDataService;


    TestimonyService testimonyService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Testimony> all = testimonyService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable int id) {
        Testimony byId = testimonyService.getById(id);
        return ResponseEntity.ok(byId);

    }

    @PostMapping
    public HttpEntity<?> insert(@RequestParam("comment") String comment, @RequestParam("name") String name,
                                @RequestParam("job") String job, @RequestParam("image")
                                MultipartFile file) throws IOException {
        ImageData imageData = imageDataService.uploadImage(file);

        Testimony testimony = new Testimony();
        testimony.setName(name);
        testimony.setJob(job);
        testimony.setComment(comment);
        testimony.setImage(imageData.getId());


        Testimony insert = testimonyService.insert(testimony);
        return ResponseEntity.status(HttpStatus.CREATED).body(insert);


    }

    @PatchMapping("/{id}")
    public HttpEntity<?> update(@PathVariable int id, @RequestParam(value = "comment",
            required = false) String comment,
                                @RequestParam(value = "job", required = false) String job,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "image", required = false)
                                MultipartFile file) throws IOException {
        ImageData imageData = null;
        Testimony testimony = new Testimony();
        if (file != null) {
            imageData = imageDataService.uploadImage(file);
            testimony.setImage(imageData.getId());
        } else {
            testimony.setImage(null);
        }

        testimony.setName(name);
        testimony.setJob(job);
        testimony.setComment(comment);
        Testimony insert = testimonyService.insert(testimony);
        return ResponseEntity.status(HttpStatus.CREATED).body(insert);


    }


    @DeleteMapping("/{id}")
    private HttpEntity<?> delete(@PathVariable int id) {

        testimonyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted");
    }

}
