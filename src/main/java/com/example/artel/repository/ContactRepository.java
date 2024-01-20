package com.example.artel.repository;

import com.example.artel.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {


  Optional<Contact> findBySecondName(String name);


}
