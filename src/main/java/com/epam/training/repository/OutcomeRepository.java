package com.epam.training.repository;

import com.epam.training.domain.Outcome;
import com.epam.training.domain.OutcomeOdd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeRepository extends CrudRepository<Outcome, Integer> {
    Outcome findByOutcomeOdds(OutcomeOdd outcomeOdd);
}
