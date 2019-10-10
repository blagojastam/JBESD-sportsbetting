package com.epam.training;

import com.epam.training.domain.*;
import com.epam.training.service.*;
import com.epam.training.view.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

    private SportsBettingService service;
    private View view;
    private Player player;
    private SportEvent sportEvent;

    public App(SportsBettingService service, View view) {
        this.service = service;
        this.view = view;
    }

    public static void main(String[] args) {
        App app = new App(new SportsBettingServiceImpl(), new ViewImpl());
        app.setUp();

        app.play();



    }

    public void play() {
        view.printWelcomeMessage();
        Player currentPlayer = view.readPlayerData();
        view.printBalance(currentPlayer);
        view.selectOutcomeOdd(null);

    }

    void createPlayer() {
        player = new Player.Builder("John Doe")
                .withAccountBalance(new BigDecimal("1000"))
                .withCurrency(Currency.EUR)
                .withAccountNumber(213341)
                .withBirthDate(LocalDateTime.of(1990,1,1,13,37))
                .build();
    }

    void doBetting() {

    }

    void calculateResults() {

    }

    void printResults () {

    }

    void setUp() {
        this.createPlayer();
        Result result = new Result();

        // Simulate JPA linker tables
        List<Bet> bets = new LinkedList<>();
        List<OutcomeOdd> outcomeodds1 = new LinkedList<>();
        List<OutcomeOdd> outcomeodds2 = new LinkedList<>();
        List<Outcome> outcomes1 = new LinkedList<>();
        List<Outcome> outcomes2 = new LinkedList<>();

        this.sportEvent = new SportEvent.Builder("Rafa Nadal vs. Roger Federer")
                .withStartDate(LocalDateTime.now()
                        .minusDays(1))
                .withEndDate(LocalDateTime.now()
                        .minusDays(1)
                        .plusHours(3))
                .withBets(bets)
                .withResult(result)
                .buildTennisEvent();

        Bet bet1 = new Bet.Builder("Roger Federer wins.")
                .withType(BetType.WINNER)
                .withSportEvent(this.sportEvent)
                .withOutcomes(outcomes1)
                .build();

        Bet bet2 = new Bet.Builder("Match is played in 3 sets.")
                .withType(BetType.NUMBER_OF_SETS)
                .withSportEvent(this.sportEvent)
                .withOutcomes(outcomes2)
                .build();

        Outcome outcome1 = new Outcome.Builder("Roger Federer wins.")
                .withBet(bet1)
                .withOutcomeOdds(outcomeodds1)
                .build();

        Outcome outcome2 = new Outcome.Builder("Match is played in 3 sets.")
                .withBet(bet2)
                .withOutcomeOdds(outcomeodds2)
                .build();

        OutcomeOdd outcomeOdd1 = new OutcomeOdd.Builder(new BigDecimal("1.3"))
                .withOutcome(outcome1)
                .validFrom(LocalDateTime.now().minusDays(2))
                .validUntil(LocalDateTime.now().plusDays(1))
                .withWager(null)
                .build();

        OutcomeOdd outcomeOdd2 = new OutcomeOdd.Builder(new BigDecimal("1.1"))
                .withOutcome(outcome2)
                .validFrom(LocalDateTime.now().minusDays(2))
                .validUntil(LocalDateTime.now().plusDays(1))
                .withWager(null)
                .build();

        outcomeodds1.add(outcomeOdd1);
        outcomeodds2.add(outcomeOdd2);

        outcomes1.add(outcome1);
        outcomes2.add(outcome2);

        result.setWinnerOutcomes(outcomes1);
    }
}
