package com.webdev.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T add(T obj);

    Optional<T> get(int id);

    List<T> getAll();

    T update(T obj);

    void delete(int id);
}
