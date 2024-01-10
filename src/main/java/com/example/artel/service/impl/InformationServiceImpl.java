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
        Information information1 = checkInformation(editedInformation, information);

        informationRepository.save(information1);
    }

    @Override
    public Information insert(Information information) {
        return informationRepository.save(information);
    }


    private Information checkInformation(Information oldInformation, Information newInformation) {

        if (newInformation.getAbout_en() != null) {
            oldInformation.setAbout_en(newInformation.getAbout_en());
        }
        if (newInformation.getAbout_ru() != null) {
            oldInformation.setAbout_ru(newInformation.getAbout_ru());
        }
        if (newInformation.getAbout_uz() != null) {
            oldInformation.setAbout_uz(newInformation.getAbout_uz());
        }
        if (newInformation.getNumber() != null) {
            oldInformation.setNumber(newInformation.getNumber());
        }
        if (newInformation.getEmail() != null) {
            oldInformation.setEmail(newInformation.getEmail());
        }
        if (newInformation.getLocation() != null) {
            oldInformation.setLocation(newInformation.getLocation());


        }
        return oldInformation;
    }
}


