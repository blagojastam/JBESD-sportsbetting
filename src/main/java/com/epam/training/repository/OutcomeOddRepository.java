package com.epam.training.repository;

import com.epam.training.domain.OutcomeOdd;
import com.epam.training.domain.Wager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeOddRepository extends CrudRepository<OutcomeOdd, Integer> {
    OutcomeOdd findByWager(Wager wager);
}
