package com.example.artel.service.impl;

import com.example.artel.entity.Contact;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.payload.ContactDto;
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
        Contact editedContact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
        editedContact.setEmail(contact.getEmail());
        editedContact.setNumber(contact.getNumber());
        editedContact.setFirstName(contact.getFirstName());
        editedContact.setMessage(contact.getMessage());
        editedContact.setSecondName(contact.getSecondName());
        contactRepository.save(editedContact);
    }

    @Override
    public Contact insert(Contact contact) {
        Contact contact1 = new Contact();
        contact1.setSecondName(contact.getSecondName());
        contact1.setEmail(contact.getEmail());
        contact1.setMessage(contact.getMessage());
        contact1.setFirstName(contact.getFirstName());
        contact1.setNumber(contact.getNumber());
        return contactRepository.save(contact1);

    }
}
