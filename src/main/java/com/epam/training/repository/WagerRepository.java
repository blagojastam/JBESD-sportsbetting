package com.epam.training.repository;

import com.epam.training.domain.Wager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WagerRepository extends CrudRepository<Wager, Integer> {
    List<Wager> findAll();
}
