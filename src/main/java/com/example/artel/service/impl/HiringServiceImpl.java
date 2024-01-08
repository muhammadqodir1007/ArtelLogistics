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
        hiring1.setComment(hiring.getComment());
        hiring1.setName(hiring.getName());
        hiring1.setEmail(hiring.getEmail());
        hiring1.setCity(hiring.getCity());
        hiring1.setExperience(hiring.getExperience());
        hiringRepository.save(hiring1);
    }

    @Override
    public Hiring insert(Hiring hiring) {
        return hiringRepository.save(hiring);
    }
}
