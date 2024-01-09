package com.example.artel.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageData, Integer> {


    Optional<ImageData> findByName(String name);
}
