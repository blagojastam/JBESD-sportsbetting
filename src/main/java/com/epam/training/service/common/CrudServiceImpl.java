package com.epam.training.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
abstract public class CrudServiceImpl<T, ID> implements CrudService<T, ID>{

    @Autowired
    CrudRepository<T, ID> repository;

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void save(T entity) {
        repository.save(entity);
    }

    @Override
    public void saveAll(Iterable<T> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
