package com.epam.training.service;

import com.epam.training.domain.*;
import com.epam.training.repository.*;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class SportsBettingServiceImpl implements SportsBettingService {
    Player currentPlayer;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    SportEventRepository sportEventRepository;

    @Autowired
    WagerRepository wagerRepository;

    @Autowired
    OutcomeOddRepository outcomeOddRepository;

    @Autowired
    OutcomeRepository outcomeRepository;

    @Autowired
    BetRepository betRepository;

    @Override
    public void savePlayer(Player player) {
        this.currentPlayer = player;
        playerRepository.save(player);
        log.info("Player " + player + " saved.");
    }

    @Override
    public Player findPlayer() {
        return currentPlayer;
    }

    @Override
    public List<SportEvent> findAllSportEvents() {
        return sportEventRepository.findAll();
    }

    @Override
    public void saveWager(Wager wager) {

        wagerRepository.save(wager);
        log.info("Wager " + wager + " saved.");

        OutcomeOdd outcomeOdd = wager.getOdd();
        outcomeOdd.setWager(wager);
        outcomeOddRepository.save(outcomeOdd);
    }

    @Override
    public List<Wager> findAllWagers() {
        return wagerRepository.findAll();
    }

    @Override
    public void calculateResults() {

        for (Wager wager : findAllWagers()) {
            OutcomeOdd outcomeOdd = outcomeOddRepository.findByWager(wager);
            Outcome wageredOutcome = outcomeRepository.findByOutcomeOdds(outcomeOdd);
            Bet bet = betRepository.findByOutcomesContains(wageredOutcome);
            SportEvent sportEvent = sportEventRepository.findByBetsContaining(bet);
            Result result = sportEvent.getResult();

            List<Outcome> winnerOutcomes = result.getWinnerOutcomes();

            if (winnerOutcomes.contains(wageredOutcome)) {
                BigDecimal oldPlayerBalance = currentPlayer.getBalance();
                List<OutcomeOdd> outcomeOdds = wageredOutcome.getOutcomeOdds();
                OutcomeOdd last = outcomeOdds.get(outcomeOdds.size()-1); // only the most recent outcome is considered
                BigDecimal coefficient = last.getValue();
                BigDecimal wagerAmount = last.getWager().getAmount();
                BigDecimal winnings = wagerAmount.multiply(coefficient);
                BigDecimal newPlayerBalance = oldPlayerBalance.add(winnings);
                currentPlayer.setBalance(newPlayerBalance);
                playerRepository.save(currentPlayer);
                wager.setWin(true);
            }
            wager.setProcessed(true);
            wagerRepository.save(wager);
            log.info("Wager " + wager + " processed.");
        }
    }
}
