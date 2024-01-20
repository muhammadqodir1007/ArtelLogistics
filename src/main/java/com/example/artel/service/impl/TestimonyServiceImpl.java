package com.example.artel.service.impl;

import com.example.artel.entity.Testimony;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.TestimonyRepository;
import com.example.artel.service.TestimonyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class TestimonyServiceImpl implements TestimonyService {
    TestimonyRepository testimonyRepository;

    @Override
    public List<Testimony> getAll() {
        return testimonyRepository.findAll();
    }

    @Override
    public Testimony getById(int id) {
        return testimonyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Testimony not found"));
    }

    @Override
    public void deleteById(int id) {
        testimonyRepository.deleteById(id);

    }

    @Override
    public void update(int id, Testimony testimony) throws IOException {
        Testimony oldTestimony = testimonyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("testimony not found"));
        Testimony testimony1 = checkTestimony(oldTestimony, testimony);
        testimonyRepository.save(testimony1);

    }

    @Override
    public Testimony insert(Testimony testimony) throws IOException {
        return testimonyRepository.save(testimony);
    }


    private Testimony checkTestimony(Testimony oldTestimony, Testimony newTestimony) {


        if (newTestimony.getComment() != null) {
            oldTestimony.setComment(newTestimony.getComment());
        }
        if (newTestimony.getImage() != null) {
            oldTestimony.setImage(newTestimony.getImage());
        }
        if (newTestimony.getJob() != null) {
            oldTestimony.setJob(newTestimony.getJob());
        }
        return oldTestimony;
    }


}
