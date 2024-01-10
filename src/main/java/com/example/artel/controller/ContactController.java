package com.example.artel.controller;

import com.example.artel.entity.Contact;
import com.example.artel.service.ContactService;
import com.example.artel.telegram.SenderTelegramBot;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/contact")
public class ContactController {


    ContactService contactService;
    SenderTelegramBot senderTelegramBot;

    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody Contact contact) throws IOException {
        Contact insert = contactService.insert(contact);
        senderTelegramBot.sendContact(contact);
        return ResponseEntity.ok(insert);
    }


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Contact> all = contactService.getAll();
        return ResponseEntity.ok(all);


    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Contact byId = contactService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public HttpEntity<?> update(@PathVariable int id, @RequestBody Contact contact) throws IOException {
        contactService.update(id, contact);
        return ResponseEntity.ok("Resource updated successfully");

    }


}
