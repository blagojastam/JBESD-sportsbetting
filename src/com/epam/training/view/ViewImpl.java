package com.epam.training.view;

import com.epam.training.domain.OutcomeOdd;
import com.epam.training.domain.Player;
import com.epam.training.domain.SportEvent;
import com.epam.training.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public class ViewImpl implements View {
    @Override
    public Player readPlayerData() {
        return null;
    }

    @Override
    public void printWelcomeMessage() {

    }

    @Override
    public void printBalance(Player player) {

    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEvents) {

    }

    @Override
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) {
        return null;
    }

    @Override
    public BigDecimal readWagerAmount() {
        return null;
    }

    @Override
    public void printSavedWager(Wager wager) {

    }

    @Override
    public void printNotEnoughBalance(Player player) {

    }

    @Override
    public void printResults(Player player, List<Wager> wagers) {

    }
}
