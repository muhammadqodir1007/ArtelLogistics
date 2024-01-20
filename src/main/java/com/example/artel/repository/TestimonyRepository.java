package com.example.artel.repository;

import com.example.artel.entity.Testimony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonyRepository extends JpaRepository<Testimony, Integer> {
}
