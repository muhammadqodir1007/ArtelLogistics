package com.example.artel.service.impl;

import com.example.artel.entity.ServiceType;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.ServiceTypeRepository;
import com.example.artel.service.ServiceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceTypeServiceImpl implements ServiceTypeService {

    ServiceTypeRepository repository;


    @Override
    public List<ServiceType> getAll() {
        return repository.findAll();
    }

    @Override
    public ServiceType getById(int id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("service not found"));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    public void update(int id, ServiceType serviceType) throws IOException {
        ServiceType oldService = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("service not found"));
        ServiceType serviceType1 = checkService(oldService, serviceType);
        ServiceType save = repository.save(serviceType1);
    }

    @Override
    public ServiceType insert(ServiceType serviceType) throws IOException {
        return repository.save(serviceType);
    }


    private ServiceType checkService(ServiceType oldService, ServiceType newService) {
        if (newService.getTitle_en() != null) {
            oldService.setTitle_en(newService.getTitle_en());
        }
        if (newService.getTitle_uz() != null) {
            oldService.setTitle_uz(newService.getTitle_uz());
        }
        if (newService.getTitle_ru() != null) {
            oldService.setTitle_ru(newService.getTitle_ru());
        }
        if (newService.getDescription_ru() != null) {
            oldService.setDescription_ru(newService.getDescription_ru());
        }
        if (newService.getDescription_uz() != null) {
            oldService.setDescription_uz(newService.getDescription_uz());
        }
        if (newService.getDescription_en() != null) {
            oldService.setDescription_en(newService.getDescription_en());
        }
        return oldService;

    }
}
