package com.example.artel.service.impl;

import com.example.artel.entity.Contact;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.ContactRepository;
import com.example.artel.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    ContactRepository contactRepository;


    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(int id) {
        return contactRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Contact not found"));
    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public void update(int id, Contact contact) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public Contact insert(Contact contact) {
        return contactRepository.save(contact);

    }


}
