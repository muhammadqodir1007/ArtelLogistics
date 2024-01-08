package com.example.artel.service.impl;

import com.example.artel.entity.Information;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.InformationRepository;
import com.example.artel.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InformationServiceImpl implements InformationService {
    InformationRepository informationRepository;


    @Override
    public List<Information> getAll() {
        return informationRepository.findAll();
    }

    @Override
    public Information getById(int id) {
        return informationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Information not found"));

    }

    @Override
    public void deleteById(int id) {
        informationRepository.deleteById(id);
    }

    @Override
    public void update(int id, Information information) {
        Information editedInformation = informationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Information not found"));
        editedInformation.setAbout_en(information.getAbout_en());
        editedInformation.setNumber(information.getNumber());
        editedInformation.setLocation(information.getLocation());
        editedInformation.setEmail(information.getEmail());
        informationRepository.save(editedInformation);
    }

    @Override
    public Information insert(Information information) {
    return     informationRepository.save(information);
    }
}
