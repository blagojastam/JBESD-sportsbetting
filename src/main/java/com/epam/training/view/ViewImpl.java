package com.epam.training.view;

import com.epam.training.domain.*;
import com.epam.training.domain.Currency;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
public class ViewImpl implements View {
    @Override
    public Player readPlayerData() {
        Scanner reader = new Scanner(System.in);

        System.out.println("\nBefore we begin, can we please get your details? ");
        System.out.print("Your name: ");
        String fullName = reader.nextLine();

        System.out.println("\nWhat kind of currency would you like to deposit? " +
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

        System.out.print("\nWhat amount would you like to deposit to your bank account? ");
        BigDecimal amount = new BigDecimal(reader.next());

        System.out.print("\nYour birthdate: [DD-MM-YYYY] ");
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
        System.out.println("\nWelcome to the sports betting application. Our code might be spaghetti, but no worries," +
                " we will still take your money!");
    }

    @Override
    public void printBalance(Player player) {
        System.out.println();
        String currencySymbol;
        switch (player.getCurrency()) {
            case HUF:
                currencySymbol = "HUF";
                System.out.println("Account balance: " + player.getBalance() + currencySymbol);
                break;
            case EUR:
                currencySymbol = "€";
                System.out.println("Account balance: " + player.getBalance() + currencySymbol);
                break;
            case USD:
                currencySymbol = "$";
                System.out.println("Account balance: " + currencySymbol + player.getBalance());
                break;
            default:
                currencySymbol = "HUF";
                System.out.println("Account balance: " + player.getBalance() + currencySymbol);
                break;
        }
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        System.out.println("\n----- Listing Outcome Odds -----");
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
        System.out.println("\nPlease choose an Outcome Odd.");

        int index = 1;
        HashMap<Integer, OutcomeOdd> map = new HashMap<>();
        for (SportEvent sportEvent : sportEvents) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome: bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        map.put(index, outcomeOdd);
                        System.out.println(index++ + ". " + outcomeOdd.getOutcome().getDescription() +
                                "\n   Odds: " + outcomeOdd.getValue() +
                                "\n   Valid between: " + outcomeOdd.getValidFrom() + " - " + outcomeOdd.getValidUntil());
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
        System.out.print("\nWhat amount would you like to wager? ");
        return new BigDecimal(reader.next());
    }

    @Override
    public void printSavedWager(Wager wager) {
        System.out.println("\n----- Wager details -----" +
                "\nPlayer name: " + wager.getPlayer().getName() +
                "\nWager amount: " + wager.getAmount() + wager.getCurrency() +
                "\nWager odd: " + wager.getOdd().getValue() +
                "\nWager description: " + wager.getOdd().getOutcome().getDescription());
    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println("\nThere is not enough balance on the account");
        printBalance(player);
    }

    @Override
    public void printResults(Player player, List<Wager> wagers) {
        List<Wager> playerWagers = wagers.stream().filter(
                wager -> wager.getPlayer() == player)
                .collect(Collectors.toList());
        for (Wager wager : playerWagers) {
            System.out.println("Wager: " + wager.getOdd().getOutcome().getDescription() +
                    "\nAmount: " + wager.getAmount() +
                    "\nWon: " +wager.getWin());
        }
    }
}
