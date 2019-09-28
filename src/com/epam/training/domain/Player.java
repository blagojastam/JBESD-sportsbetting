package com.epam.training.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Player extends User {
    String name;
    int accountNumber;
    BigDecimal balance;
    LocalDateTime birth;
    Currency currency;

    private Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public static class Builder {
        String name;
        int accountNumber;
        BigDecimal balance;
        LocalDateTime birth;
        Currency currency;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withAccountNumber(int accountNumber) {
            this.accountNumber = accountNumber;

            return this;
        }

        public Builder withAccountBalance(BigDecimal accountBalance) {
            this.balance = accountBalance;

            return this;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;

            return this;
        }

        public Builder withBirthDate(LocalDateTime birth) {
            this.birth = birth;

            return this;
        }

        public Player build() {
            Player player = new Player();
            player.name = this.name;
            player.accountNumber = this.accountNumber;
            player.balance = this.balance;
            player.currency = this.currency;
            player.birth = this.birth;

            player.email = getEmailAddress(player.name);

            int hash = Arrays.hashCode("Areyoukiddingme?".getBytes());
            player.password = Integer.toString(hash);

            return player;
        }

        private String getEmailAddress(String name) {
            String[] nameComponents = name.split(" ");

            String emailFirstComponent = nameComponents[0].toLowerCase();
            String emailSecondComponent = nameComponents[1].toLowerCase();

            String email = emailFirstComponent + "." + emailSecondComponent + "@epam.com";

            return email;
        }
    }
}
