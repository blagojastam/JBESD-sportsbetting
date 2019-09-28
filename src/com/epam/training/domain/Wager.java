package com.epam.training.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {
    BigDecimal amount;
    LocalDateTime timestampCreated;
    Boolean processed;
    Boolean win;
    Player player;
    Currency currency;
    OutcomeOdd odd;

    public Wager() {
        timestampCreated = LocalDateTime.now();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public OutcomeOdd getOdd() {
        return odd;
    }

    public void setOdd(OutcomeOdd odd) {
        this.odd = odd;
    }
}
