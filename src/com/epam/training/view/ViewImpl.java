package com.epam.training.view;

import com.epam.training.domain.*;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class ViewImpl implements View {
    @Override
    public Player readPlayerData() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Before we begin, can we please get your details? ");
        System.out.print("Your name: ");
        String fullName = reader.nextLine();

        System.out.println("What kind of currency would you like to deposit? " +
                "\n1. HUF" +
                "\n2. EUR" +
                "\n3. USD");
        int currencyChoice = Integer.parseInt(reader.next());
        Currency currency;
        switch (currencyChoice) {
            case 1: currency = Currency.HUF; break;
            case 2: currency = Currency.EUR; break;
            case 3: currency = Currency.USD; break;
            default: currency = Currency.HUF; break;
        }

        System.out.print("What amount would you like to deposit? ");
        BigDecimal amount = new BigDecimal(reader.next());

        System.out.print("Your birthdate: [DD-MM-YYYY] ");
        String birthdateString = reader.next();
        String[] birthdateData = birthdateString.split("-");
        LocalDateTime birthdate = LocalDateTime.of(
                Integer.parseInt(birthdateData[2]),
                Integer.parseInt(birthdateData[1]),
                Integer.parseInt(birthdateData[0]),
                13,
                37);

        Random r = new Random();
        int accountNumber = r.nextInt(3000000);

        return new Player.Builder(fullName)
                .withAccountNumber(accountNumber)
                .withAccountBalance(amount)
                .withBirthDate(birthdate)
                .withCurrency(currency)
                .build();
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to the sports betting application. Our code might be spaghetti, but no worries," +
                " we will still take your money!");
    }

    @Override
    public void printBalance(Player player) {
        System.out.println("----- Player details -----");
        System.out.println("Name: " + player.getName());
        System.out.println("Email address: " + player.getEmail());
        System.out.println("Birthdate: " + player.getBirth());
        System.out.println("Account number: " + player.getAccountNumber());
        System.out.println("Account currency: " + player.getCurrency());
        System.out.println("Account balance: " + player.getBalance());
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        System.out.println("----- Listing Outcome Odds -----");
        for (SportEvent sportEvent : sportEvents) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome: bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        System.out.println("Outcome odd rate: " + outcomeOdd.getValue());
                        System.out.println("Outcome odd valid from: " + outcomeOdd.getValidFrom());
                        System.out.println("Outcome odd valid until: " + outcomeOdd.getValidUntil());
                        System.out.println("Outcome odd parent Outcome: " + outcomeOdd.getOutcome());
                        System.out.println();
                    }
                }
            }
        }
    }

    @Override
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) {
        System.out.println("Please choose an Outcome Odd.");

        int index = 1;
        HashMap<Integer, OutcomeOdd> map = new HashMap<>();
        for (SportEvent sportEvent : sportEvents) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome: bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        map.put(index, outcomeOdd);
                        System.out.println(index++ + ". Outcome odd Outcome: " + outcomeOdd.getOutcome());

                    }
                }
            }
        }

        Scanner reader = new Scanner(System.in);
        int key = reader.nextInt();

        return map.get(key);
    }

    @Override
    public BigDecimal readWagerAmount() {
        Scanner reader = new Scanner(System.in);
        System.out.print("What amount would you like to wager? ");
        return new BigDecimal(reader.next());
    }

    @Override
    public void printSavedWager(Wager wager) {

    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println("There is not enough balance on the account");
        printBalance(player);
    }

    @Override
    public void printResults(Player player, List<Wager> wagers) {

    }
}
