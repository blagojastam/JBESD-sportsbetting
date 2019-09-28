package com.epam.training.service;

import com.epam.training.domain.Player;
import com.epam.training.domain.SportEvent;
import com.epam.training.domain.Wager;

import java.util.List;

public class SportsBetingServiceImpl implements SportsBettingService {
    Player currentPlayer;
    List<SportEvent> sportEvents;
    List<Wager> wagers;

    @Override
    public void savePlayer(Player player) {
        this.currentPlayer = player;
    }

    @Override
    public Player findPlayer() {
        return currentPlayer;
    }

    @Override
    public List<SportEvent> findAllSportEvents() {
        return sportEvents;
    }

    @Override
    public void saveWager(Wager wager) {
        wagers.add(wager); // TODO: Change creational pattern
    }

    @Override
    public List<Wager> findAllWagers() {
        return wagers;
    }

    @Override
    public void calculateResults() {
        // TODO : Implement logic
    }
}
