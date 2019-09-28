package com.epam.training.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {
    BigDecimal value;
    LocalDateTime validFrom;
    LocalDateTime validUntil;
    Wager wager;
    Outcome outcome;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public Wager getWager() {
        return wager;
    }

    public void setWager(Wager wager) {
        this.wager = wager;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}
