package com.epam.training.service.common;

import java.util.Optional;

public interface CrudService<T, ID> {
    Iterable<T> findAll();
    Optional<T> findById(ID id);
    void save(T entity);
    void saveAll(Iterable<T> entities);
    void delete(T entity);
    void deleteAll();
}
