package com.epam.training.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OutcomeOdd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private BigDecimal value;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;

    @OneToOne
    private Wager wager;

    @ManyToOne
    private Outcome outcome;

    private OutcomeOdd() {

    }

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

    public static class Builder {
        private BigDecimal value;
        private LocalDateTime validFrom;
        private LocalDateTime validUntil;
        private Wager wager;
        private Outcome outcome;

        public Builder(BigDecimal value) {
            this.value = value;
        }

        public Builder validFrom(LocalDateTime validFrom) {
            this.validFrom = validFrom;

            return this;
        }

        public Builder validUntil(LocalDateTime validUntil) {
            this.validUntil = validUntil;

            return this;
        }

        public Builder withWager(Wager wager) {
            this.wager = wager;

            return this;
        }

        public Builder withOutcome(Outcome outcome) {
            this.outcome = outcome;

            return this;
        }

        public OutcomeOdd build() {
            OutcomeOdd outcomeOdd = new OutcomeOdd();

            outcomeOdd.value = this.value;
            outcomeOdd.validFrom = this.validFrom;
            outcomeOdd.validUntil = this.validUntil;
            outcomeOdd.wager = this.wager;
            outcomeOdd.outcome = this.outcome;

            return outcomeOdd;
        }
    }
}
