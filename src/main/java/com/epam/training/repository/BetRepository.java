package com.epam.training.repository;

import com.epam.training.domain.Bet;
import com.epam.training.domain.Outcome;
import com.epam.training.domain.SportEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<Bet, Integer> {
    List<Bet> findAllByEvent(SportEvent event);
    Bet findByOutcomesContains(Outcome outcome);
}
