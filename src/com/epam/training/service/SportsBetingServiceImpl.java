package com.epam.training.service;

import com.epam.training.domain.Player;
import com.epam.training.domain.SportEvent;
import com.epam.training.domain.Wager;

import java.util.List;

public class SportsBetingServiceImpl implements SportsBettingService {
    Player currentPlayer;

    @Override
    public void savePlayer(Player player) {
        this.currentPlayer = player;
    }

    @Override
    public Player findPlayer() {
        return this.currentPlayer;
    }

    @Override
    public List<SportEvent> findAllSportEvents() {
        return null;
    }

    @Override
    public void saveWager(Wager wager) {

    }

    @Override
    public List<Wager> findAllWagers() {
        return null;
    }

    @Override
    public void calculateResults() {

    }
}
