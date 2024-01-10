package com.example.artel.service;

import java.io.IOException;
import java.util.List;

public interface AbstractService<T> {
    List<T> getAll();

    T getById(int id);

    void deleteById(int id);

    void update(int id, T t) throws IOException;

    T insert(T t) throws IOException;
}
