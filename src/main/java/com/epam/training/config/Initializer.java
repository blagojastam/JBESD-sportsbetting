package com.epam.training.config;

import com.epam.training.domain.*;
import com.epam.training.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class Initializer {

    @Autowired
    PlayerService playerService;

    @Autowired
    BettingAccountService bettingAccountService;

    @Autowired
    SportEventService sportEventService;

    @Autowired
    PossibleOutcomeService possibleOutcomeService;

    @Autowired
    BetService betService;

    public void setUp(){
        Player blagoja = new Player();
        blagoja.setPassword("h3h3");
        blagoja.setUsername("blagoja");
        blagoja.setEmail("blagoja.stamatovski@epam.com");
        blagoja.setBirthdate(LocalDateTime.now().minusYears(22));
        blagoja.setName("Blagoja Stamatovski");
        blagoja.setEnabled(true);
        playerService.saveNew(blagoja);

        BettingAccount bettingAccount = new BettingAccount();
        bettingAccount.setOwner(blagoja);
        bettingAccount.setCurrency(Currency.EUR);
        bettingAccount.setBalance(150);
        bettingAccountService.save(bettingAccount);

        BettingAccount bettingAccount2 = new BettingAccount();
        bettingAccount2.setOwner(blagoja);
        bettingAccount2.setCurrency(Currency.HUF);
        bettingAccount2.setBalance(10000);
        bettingAccountService.save(bettingAccount2);

        SportEvent tennisEvent = new TennisSportEvent();
        tennisEvent.setTitle("Rafa Nadal vs Roger Federer");
        tennisEvent.setStartDate(LocalDateTime.now().plusMinutes(5));
        tennisEvent.setEndDate(LocalDateTime.now().plusHours(3));
        sportEventService.save(tennisEvent);

        PossibleOutcome nadalWins = new PossibleOutcome();
        nadalWins.setSportEvent(tennisEvent);
        nadalWins.setOutcomeType(OutcomeType.WINNER);
        nadalWins.setWinningCondition("Rafa Nadal");
        nadalWins.setRatio(1.3);
        possibleOutcomeService.save(nadalWins);

        PossibleOutcome federerWins = new PossibleOutcome();
        federerWins.setSportEvent(tennisEvent);
        federerWins.setOutcomeType(OutcomeType.WINNER);
        federerWins.setWinningCondition("Roger Federer");
        federerWins.setRatio(1.1);
        possibleOutcomeService.save(federerWins);

        PossibleOutcome threeSets = new PossibleOutcome();
        threeSets.setSportEvent(tennisEvent);
        threeSets.setOutcomeType(OutcomeType.NUMBER_OF_SETS);
        threeSets.setWinningCondition(String.valueOf(3));
        threeSets.setRatio(1.05);
        possibleOutcomeService.save(threeSets);

        SportEvent footballEvent = new FootballSportEvent();
        footballEvent.setTitle("Real Madrid vs Barcelona");
        footballEvent.setStartDate(LocalDateTime.now().minusMinutes(15));
        footballEvent.setEndDate(LocalDateTime.now().plusHours(2));
        sportEventService.save(footballEvent);

        PossibleOutcome realWins = new PossibleOutcome();
        realWins.setSportEvent(footballEvent);
        realWins.setOutcomeType(OutcomeType.WINNER);
        realWins.setWinningCondition("Real Madrid");
        realWins.setRatio(1.3);
        possibleOutcomeService.save(realWins);

        PossibleOutcome barcaWins = new PossibleOutcome();
        barcaWins.setSportEvent(footballEvent);
        barcaWins.setOutcomeType(OutcomeType.WINNER);
        barcaWins.setWinningCondition("Barcelona");
        barcaWins.setRatio(1.2);
        possibleOutcomeService.save(barcaWins);

        PossibleOutcome messiScores = new PossibleOutcome();
        messiScores.setSportEvent(footballEvent);
        messiScores.setOutcomeType(OutcomeType.PLAYER_SCORES);
        messiScores.setWinningCondition("Messi");
        barcaWins.setRatio(1.8);
        possibleOutcomeService.save(messiScores);

        Bet betOnFederer = new Bet();
        betOnFederer.setPlayer(blagoja);
        betOnFederer.setPossibleOutcome(federerWins);
        betOnFederer.setAmount(100);
        betOnFederer.setCurrency(Currency.EUR);
        betService.save(betOnFederer);

        Bet betOnThreeSets = new Bet();
        betOnThreeSets.setPlayer(blagoja);
        betOnThreeSets.setPossibleOutcome(threeSets);
        betOnThreeSets.setAmount(6000);
        betOnThreeSets.setCurrency(Currency.HUF);
        betOnThreeSets.setProcessed(true);
        betOnThreeSets.setWon(false);
        betService.save(betOnThreeSets);

        Bet betOnBarca = new Bet();
        betOnBarca.setPlayer(blagoja);
        betOnBarca.setPossibleOutcome(barcaWins);
        betOnBarca.setAmount(30);
        betOnBarca.setCurrency(Currency.EUR);
        betOnBarca.setProcessed(true);
        betOnBarca.setWon(true);
        betService.save(betOnBarca);
    }
}
