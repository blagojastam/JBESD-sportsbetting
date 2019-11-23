package com.epam.training.repository;

import com.epam.training.domain.Outcome;
import com.epam.training.domain.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends CrudRepository<Result, Integer> {
//    List<Outcome> findAllByWinnerOutcomesContaining()
}
