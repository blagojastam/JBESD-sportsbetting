package com.epam.training.view;

import com.epam.training.domain.*;
import com.epam.training.domain.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
@SuppressWarnings("Duplicates")
public class ViewImpl implements View {
    @Autowired
    private ResourceBundle messages;

    @Override
    public Player readPlayerData() {
        Scanner reader = new Scanner(System.in);

        System.out.println("\n" + messages.getString("before_beginning"));
        System.out.print(messages.getString("your_name"));
        String fullName = reader.nextLine();

        System.out.print(messages.getString("currency_choice"));
        String currencyChoice = reader.next();
        Currency currency = Currency.valueOf(currencyChoice.toUpperCase());

        BigDecimal amount;
        boolean validAmountGiven = false;
        do {
            System.out.print(messages.getString("what_amount"));
            amount = new BigDecimal(reader.next());
            if (!(amount.compareTo(BigDecimal.ZERO) == 1)) {
                System.out.print(messages.getString("value_gt0_needed"));
                log.warn("User gave value less than or equal to 0. ");
            } else {
                validAmountGiven = true;
            }
        } while (!validAmountGiven);

        LocalDateTime birthdate;
        boolean defaultBirthdate = true;
        if (!defaultBirthdate){
            System.out.print(messages.getString("your_birthdate"));
            String birthdateString = reader.next();
            String[] birthdateData = birthdateString.split("-");
            birthdate = LocalDateTime.of(
                    Integer.parseInt(birthdateData[2]),
                    Integer.parseInt(birthdateData[1]),
                    Integer.parseInt(birthdateData[0]),
                    13,
                    37);
        } else {
            log.info("Using default birthdate. ");
            birthdate = LocalDateTime.now();
        }

        Random r = new Random();
        int accountNumber = r.nextInt(3000000);

        Player newPlayer = new Player.Builder(fullName)
                .withAccountNumber(accountNumber)
                .withAccountBalance(amount)
                .withBirthDate(birthdate)
                .withCurrency(currency)
                .build();

        log.info("Player " + newPlayer + " created.");

        return newPlayer;
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println(messages.getString("welcome_message"));
    }

    @Override
    public void printBalance(Player player) {
        System.out.println();
        String currencySymbol;
        switch (player.getCurrency()) {
            case HUF:
                currencySymbol = "HUF";
                System.out.println(messages.getString("acct_balance") + player.getBalance() + currencySymbol);
                break;
            case EUR:
                currencySymbol = "€";
                System.out.println(messages.getString("acct_balance")+ player.getBalance() + currencySymbol);
                break;
            case USD:
                currencySymbol = "$";
                System.out.println(messages.getString("acct_balance") + currencySymbol + player.getBalance());
                break;
            default:
                currencySymbol = "HUF";
                System.out.println(messages.getString("acct_balance") + player.getBalance() + currencySymbol);
                break;
        }
    }

    @Override
    @Transactional
    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        System.out.println(messages.getString("outcomeOdd_listing_message"));
        for (SportEvent sportEvent : sportEvents) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome: bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        System.out.println(messages.getString("outcomeOdd_rate") + outcomeOdd.getValue());
                        System.out.println(messages.getString("outcomeOdd_validFrom") + outcomeOdd.getValidFrom());
                        System.out.println(messages.getString("outcomeOdd_validUntil") + outcomeOdd.getValidUntil());
                        System.out.println(messages.getString("outcomeOdd_parentOutcome") + outcomeOdd.getOutcome());
                        System.out.println();
                    }
                }
            }
        }
    }

    @Override
    @Transactional
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) {
        HashMap<Integer, OutcomeOdd> map = new HashMap<>();
        Scanner reader = new Scanner(System.in);
        int key = 0;
        boolean isChoiceInvalid = true;

        while (isChoiceInvalid) {
            System.out.println(messages.getString("outcomeOdd_selectionPrompt"));
            map = new HashMap<>();

            int index = 1;
            for (SportEvent sportEvent : sportEvents) {
                for (Bet bet : sportEvent.getBets()) {
                    for (Outcome outcome: bet.getOutcomes()) {
                        for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                            map.put(index, outcomeOdd);
                            System.out.println(index++ + ". " + outcomeOdd.getOutcome().getDescription() +
                                    "\n  " + messages.getString("odds") + outcomeOdd.getValue() +
                                    "\n  " + messages.getString("valid_between") + outcomeOdd.getValidFrom() + " - " + outcomeOdd.getValidUntil());
                        }
                    }
                }
            }

            key = reader.nextInt();
            if (map.containsKey(key)) {
                isChoiceInvalid = false;
            } else {
                System.out.println(messages.getString("outcomeOdd_pleaseSelectValid"));
                log.warn("User selected invalid Outcome Odd. ");
            }
        }

        return map.get(key);
    }

    @Override
    public BigDecimal readWagerAmount() {
        Scanner reader = new Scanner(System.in);
        BigDecimal amount;
        boolean validAmountGiven = false;

        do {
            System.out.print(messages.getString("wager_promptAmount"));
            amount = new BigDecimal(reader.next());
            if (!(amount.compareTo(BigDecimal.ZERO) == 1)) {
                System.out.print(messages.getString("value_gt0_needed"));
                log.warn("User gave value less than or equal to 0. ");
            } else {
                validAmountGiven = true;
            }
        } while (!validAmountGiven);

        return amount;
    }

    @Override
    public void printSavedWager(Wager wager) {
        System.out.println(messages.getString("wager_listing_message") +
                "\n" + messages.getString("player_name") + wager.getPlayer().getName() +
                "\n" + messages.getString("wager_amount") + wager.getAmount() + wager.getCurrency() +
                "\n" + messages.getString("wager_odd") + wager.getOdd().getValue() +
                "\n" + messages.getString("wager_description") + wager.getOdd().getOutcome().getDescription());
    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println("\n" + messages.getString("not_enough_balance"));
        printBalance(player);
    }

    @Override
    public void printResults(Player player, List<Wager> wagers) {
        List<Wager> playerWagers = wagers.stream().filter(
                wager -> wager.getPlayer() == player)
                .collect(Collectors.toList());
        for (Wager wager : playerWagers) {
            System.out.println(messages.getString("wager") + wager.getOdd().getOutcome().getDescription() +
                    "\n" + messages.getString("amount") + wager.getAmount() +
                    "\n" + messages.getString("won") + wager.getWin());
        }
    }
}
