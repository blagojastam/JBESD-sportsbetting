package com.epam.training;

import com.epam.training.domain.*;
import com.epam.training.service.*;
import com.epam.training.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
@SuppressWarnings("Duplicates")
public class App {

    private SportsBettingService service;
    private View view;

    @Autowired
    public App(SportsBettingService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void play() {
        view.printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("q")) {
            System.out.println("1. Place a bet");
            System.out.println("q. Calculate results and quit");
            choice = scanner.next();
            if (choice.equals("1")) {
                doBetting();
            } else if (choice.equals("q")) {
                calculateResults();
                printResults();
            }
        }

        System.out.println("Bye bye. ");
    }

    void createPlayer() {
        service.savePlayer(view.readPlayerData());
        view.printBalance(service.findPlayer());
    }

    void doBetting() {
        Player currentPlayer = service.findPlayer();

        OutcomeOdd selectedOutcomeOdd = view.selectOutcomeOdd(service.findAllSportEvents());
        BigDecimal wagerAmount;
        BigDecimal playerBalance = currentPlayer.getBalance();

        boolean validAmountGiven = false;
        do {
            wagerAmount = view.readWagerAmount();
            if (playerBalance.compareTo(wagerAmount) == -1) {
                view.printNotEnoughBalance(currentPlayer);
            } else {
                validAmountGiven = true;
            }
        } while (!validAmountGiven);

        Wager newWager = new Wager();
        selectedOutcomeOdd.setWager(newWager);
        newWager.setAmount(wagerAmount);
        newWager.setCurrency(currentPlayer.getCurrency());
        newWager.setOdd(selectedOutcomeOdd);
        newWager.setPlayer(currentPlayer);
        newWager.setProcessed(false);
        newWager.setWin(false);

        service.saveWager(newWager);
        view.printSavedWager(newWager);
        currentPlayer.setBalance(playerBalance.subtract(wagerAmount));
        view.printBalance(currentPlayer);
    }

    void calculateResults() {
        service.calculateResults();
    }

    void printResults () {
        view.printResults(service.findPlayer(), service.findAllWagers());
    }

    // Helper method to set up dummy data.
     void initialize() {

        // Simulate JPA linker tables
        Result result1 = new Result();
        Result result2 = new Result();
        List<Bet> bets1 = new LinkedList<>();
        List<Bet> bets2 = new LinkedList<>();
        List<OutcomeOdd> outcomeodds1 = new LinkedList<>();
        List<OutcomeOdd> outcomeodds2 = new LinkedList<>();
        List<OutcomeOdd> outcomeodds3 = new LinkedList<>();
        List<OutcomeOdd> outcomeodds4 = new LinkedList<>();
        List<Outcome> outcomes1 = new LinkedList<>();
        List<Outcome> outcomes2 = new LinkedList<>();
        List<Outcome> outcomes3 = new LinkedList<>();
        List<Outcome> outcomes4 = new LinkedList<>();


        SportEvent sportEvent1 = new SportEvent.Builder("Rafa Nadal vs. Roger Federer")
                .withStartDate(LocalDateTime.now()
                        .minusDays(1))
                .withEndDate(LocalDateTime.now()
                        .minusDays(1)
                        .plusHours(3))
                .withBets(bets1)
                .withResult(result1)
                .buildTennisEvent();

        SportEvent sportEvent2 = new SportEvent.Builder("Real Madrid vs. Barcelona")
                .withStartDate(LocalDateTime.now()
                        .minusHours(1))
                .withEndDate(LocalDateTime.now()
                        .plusHours(1))
                .withBets(bets2)
                .withResult(result2)
                .buildFootballEvent();

        Bet bet1 = new Bet.Builder("Roger Federer wins.")
                .withType(BetType.WINNER)
                .withSportEvent(sportEvent1)
                .withOutcomes(outcomes1)
                .build();

        Bet bet2 = new Bet.Builder("Match is played in 3 sets.")
                .withType(BetType.NUMBER_OF_SETS)
                .withSportEvent(sportEvent1)
                .withOutcomes(outcomes2)
                .build();

        Bet bet3 = new Bet.Builder("Real Madrid wins.")
                .withType(BetType.WINNER)
                .withSportEvent(sportEvent2)
                .withOutcomes(outcomes3)
                .build();

        Bet bet4 = new Bet.Builder("Barcelona wins.")
                .withType(BetType.WINNER)
                .withSportEvent(sportEvent2)
                .withOutcomes(outcomes4)
                .build();


        Outcome outcome1 = new Outcome.Builder("Roger Federer wins.")
                .withBet(bet1)
                .withOutcomeOdds(outcomeodds1)
                .build();

        Outcome outcome2 = new Outcome.Builder("Match is played in 3 sets.")
                .withBet(bet2)
                .withOutcomeOdds(outcomeodds2)
                .build();

        Outcome outcome3 = new Outcome.Builder("Real Madrid wins.")
                .withBet(bet3)
                .withOutcomeOdds(outcomeodds3)
                .build();

        Outcome outcome4 = new Outcome.Builder("Barcelona wins.")
                .withBet(bet4)
                .withOutcomeOdds(outcomeodds4)
                .build();

        OutcomeOdd outcomeOdd1 = new OutcomeOdd.Builder(new BigDecimal("1.3"))
                .withOutcome(outcome1)
                .validFrom(LocalDateTime.now().minusDays(2))
                .validUntil(LocalDateTime.now().plusDays(1))
                .build();

        OutcomeOdd outcomeOdd2 = new OutcomeOdd.Builder(new BigDecimal("1.1"))
                .withOutcome(outcome2)
                .validFrom(LocalDateTime.now().minusDays(2))
                .validUntil(LocalDateTime.now().plusDays(1))
                .build();

        OutcomeOdd outcomeOdd3 = new OutcomeOdd.Builder(new BigDecimal("1.125"))
                .withOutcome(outcome3)
                .validFrom(LocalDateTime.now().minusDays(2))
                .validUntil(LocalDateTime.now().plusDays(1))
                .build();

        OutcomeOdd outcomeOdd4 = new OutcomeOdd.Builder(new BigDecimal("1.1337"))
                .withOutcome(outcome4)
                .validFrom(LocalDateTime.now().minusDays(2))
                .validUntil(LocalDateTime.now().plusDays(1))
                .build();

        bets1.add(bet1);
        bets1.add(bet2);
        bets2.add(bet3);
        bets2.add(bet4);

        outcomeodds1.add(outcomeOdd1);
        outcomeodds2.add(outcomeOdd2);
        outcomeodds3.add(outcomeOdd3);
        outcomeodds4.add(outcomeOdd4);

        outcomes1.add(outcome1);
        outcomes2.add(outcome2);
        outcomes3.add(outcome3);
        outcomes4.add(outcome4);

        result1.setWinnerOutcomes(outcomes1);
        result2.setWinnerOutcomes(outcomes3);

        service.findAllSportEvents().add(sportEvent1);
        service.findAllSportEvents().add(sportEvent2);
    }
}
