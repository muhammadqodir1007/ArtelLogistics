package com.example.artel.repository;

import com.example.artel.entity.Hiring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringRepository extends JpaRepository<Hiring, Integer> {
}