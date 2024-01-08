package com.example.artel.service.impl;

import com.example.artel.entity.Vacancy;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.VacancyRepository;
import com.example.artel.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        editedVacancy.setDescription_uz(vacancy.getDescription_uz());
        editedVacancy.setName(vacancy.getName());
        editedVacancy.setWorkdays(vacancy.getWorkdays());
        editedVacancy.setTitle_en(vacancy.getTitle_en());
        editedVacancy.setTitle_uz(vacancy.getTitle_uz());
        editedVacancy.setTitle_ru(vacancy.getTitle_ru());
        editedVacancy.setWorkHours(vacancy.getWorkHours());
        vacancyRepository.save(editedVacancy);
    }

    @Override
    public Vacancy insert(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }
}
