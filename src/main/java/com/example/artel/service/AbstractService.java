package com.example.artel.service;

import java.util.List;

public interface AbstractService<T> {
    List<T> getAll();

    T getById(int id);

    void deleteById(int id);

    void update(int id, T t);

    T insert(T t);
}
