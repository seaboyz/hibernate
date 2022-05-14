package com.webdev.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Dao<T> {

    T add(T obj);

    Optional<T> get(UUID id);

    List<T> getAll();

    T update(T t);

    void delete(UUID id);

    void delete(T t);

}
