package com.example.artel.service.impl;

import com.example.artel.entity.Hiring;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.HiringRepository;
import com.example.artel.service.HiringService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HiringServiceImpl implements HiringService {
    HiringRepository hiringRepository;


    @Override
    public List<Hiring> getAll() {
        return hiringRepository.findAll();
    }

    @Override
    public Hiring getById(int id) {
        return hiringRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hiring information  not found"));
    }

    @Override
    public void deleteById(int id) {
        hiringRepository.deleteById(id);

    }

    @Override
    public void update(int id, Hiring hiring) {
        Hiring hiring1 = hiringRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hiring data not found"));
        Hiring hiring2 = checkHiring(hiring1, hiring);
        hiringRepository.save(hiring2);
    }

    @Override
    public Hiring insert(Hiring hiring) {
        return hiringRepository.save(hiring);
    }


    private Hiring checkHiring(Hiring oldHiring, Hiring newHiring) {

        if (newHiring.getCity() != null) {
            oldHiring.setCity(newHiring.getCity());
        }
        if (newHiring.getName() != null) {
            oldHiring.setName(newHiring.getName());
        }
        if (newHiring.getPhone() != null) {
            oldHiring.setPhone(newHiring.getPhone());
        }
        if (newHiring.getComment() != null) {
            oldHiring.setComment(newHiring.getComment());
        }
        if (newHiring.getExperience() != null) {
            oldHiring.setExperience(newHiring.getExperience());
        }
        if (newHiring.getEmail() != null) {
            oldHiring.setEmail(newHiring.getEmail());
        }
        return oldHiring;

    }
}
