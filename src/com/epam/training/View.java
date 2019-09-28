package com.epam.training;

import com.epam.training.domain.OutcomeOdd;
import com.epam.training.domain.Player;
import com.epam.training.domain.SportEvent;
import com.epam.training.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public interface View {
    Player readPlayerData();
    void printWelcomeMessage();
    void printBalance(Player player);
    void printOutcomeOdds(List<SportEvent> sportEvents);
    OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents);
    BigDecimal readWagerAmount();
    void printSavedWager(Wager wager);
    void printNotEnoughBalance(Player player);
    void printResults(Player player, List<Wager> wagers);
}
