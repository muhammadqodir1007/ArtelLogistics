package com.example.artel.service;

import com.example.artel.payload.NewsDto;

import java.io.IOException;
import java.util.List;

public interface AbstractService<T, D> {
    List<T> getAll();

    T getById(int id);

    void deleteById(int id);

    void update(int id, D t) throws IOException;

    T insert(D t) throws IOException;
}
