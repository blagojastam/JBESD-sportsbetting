package com.epam.training.repository;

import com.epam.training.domain.Bet;
import com.epam.training.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, String> {
    List<Bet> findAllByPlayer(Player player);
}
