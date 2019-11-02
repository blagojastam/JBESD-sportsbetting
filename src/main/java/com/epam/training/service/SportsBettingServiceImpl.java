package com.epam.training.service;

import com.epam.training.domain.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class SportsBettingServiceImpl implements SportsBettingService {
    Player currentPlayer;
    List<SportEvent> sportEvents = new LinkedList<>();
    List<Wager> wagers = new LinkedList<>();

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
        wagers.add(wager);
    }

    @Override
    public List<Wager> findAllWagers() {
        return wagers;
    }

    @Override
    public void calculateResults() {

        for (Wager wager : wagers) {
            List<Outcome> winnerOutcomes = wager.getOdd().getOutcome().getBet().getEvent().getResult().getWinnerOutcomes();
            Outcome wageredOutcome = wager.getOdd().getOutcome();
            if (winnerOutcomes.contains(wageredOutcome)) {
                BigDecimal oldPlayerBalance = currentPlayer.getBalance();
                List<OutcomeOdd> outcomeOdds = wageredOutcome.getOutcomeOdds();
                OutcomeOdd last = outcomeOdds.get(outcomeOdds.size()-1); // only the most recent outcome is considered
                BigDecimal coefficient = last.getValue();
                BigDecimal wagerAmount = last.getWager().getAmount();
                BigDecimal winnings = wagerAmount.multiply(coefficient);
                BigDecimal newPlayerBalance = oldPlayerBalance.add(winnings);
                currentPlayer.setBalance(newPlayerBalance);
                wager.setWin(true);
            }
            wager.setProcessed(true);
        }
    }
}
