package com.epam.training.repository;

import com.epam.training.domain.Bet;
import com.epam.training.domain.SportEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportEventRepository extends CrudRepository<SportEvent, Integer> {
    List<SportEvent> findAll();
    SportEvent findByBetsContaining(Bet bet);
}
