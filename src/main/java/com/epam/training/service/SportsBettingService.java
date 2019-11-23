package com.epam.training.service;

import com.epam.training.domain.Player;
import com.epam.training.domain.SportEvent;
import com.epam.training.domain.Wager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SportsBettingService {
    void savePlayer(Player player);
    Player findPlayer();
    List<SportEvent> findAllSportEvents();
    void saveWager(Wager wager);
    List<Wager> findAllWagers();
    void calculateResults();
}
