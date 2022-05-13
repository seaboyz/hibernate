package com.webdev.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Dao<T> {
    Optional<T> add(T obj);

    Optional<T> getById(UUID id);

    List<T> getAll();

    T update(T obj);

    void delete(UUID id);

    void delete(T obj);
}
