package com.example.artel.service.impl;

import com.example.artel.entity.Vacancy;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.VacancyRepository;
import com.example.artel.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    VacancyRepository vacancyRepository;


    @Override
    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();

    }

    @Override
    public Vacancy getById(int id) {
        return vacancyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacancy Not Found"));
    }

    @Override
    public void deleteById(int id) {
        vacancyRepository.deleteById(id);

    }

    @Override
    public void update(int id, Vacancy vacancy) {
        Vacancy editedVacancy = vacancyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("vacancy not found"));
        Vacancy vacancy1 = checkVacancy(editedVacancy, vacancy);
        vacancyRepository.save(vacancy1);
    }

    @Override
    public Vacancy insert(Vacancy vacancy) {
        vacancy.setCreatedAt(LocalDateTime.now());
        return vacancyRepository.save(vacancy);
    }

    private Vacancy checkVacancy(Vacancy oldVacancy, Vacancy newVacancy) {

        if (newVacancy.getTitle_uz() != null) {
            oldVacancy.setTitle_uz(newVacancy.getTitle_uz());
        }
        if (newVacancy.getRemote() != null) {
            oldVacancy.setRemote(newVacancy.getRemote());
        }

        if (newVacancy.getTitle_en() != null) {
            oldVacancy.setTitle_en(newVacancy.getTitle_en());
        }
        if (newVacancy.getTitle_ru() != null) {
            oldVacancy.setTitle_ru(newVacancy.getTitle_ru());
        }
        if (newVacancy.getDescription_ru() != null) {
            oldVacancy.setDescription_ru(newVacancy.getDescription_ru());
        }
        if (newVacancy.getDescription_uz() != null) {
            oldVacancy.setDescription_uz(newVacancy.getDescription_uz());
        }
        if (newVacancy.getDescription_en() != null) {
            oldVacancy.setDescription_en(newVacancy.getDescription_en());
        }
        if (newVacancy.getWorkdays() != null) {
            oldVacancy.setWorkdays(newVacancy.getWorkdays());
        }
        if (newVacancy.getWorkHours() != null) {
            oldVacancy.setWorkHours(newVacancy.getWorkHours());
        }
        if (newVacancy.getLocation() != null) {
            oldVacancy.setLocation(newVacancy.getLocation());
        }

        return oldVacancy;


    }


}
