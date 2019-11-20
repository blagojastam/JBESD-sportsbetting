package com.epam.training.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    String description;

    @ElementCollection
    List<OutcomeOdd> outcomeOdds;

    @OneToOne
    Bet bet;

    private Outcome() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public static class Builder {
        String description;
        List<OutcomeOdd> outcomeOdds;
        Bet bet;

        public Builder(String description) {
            this.description = description;
        }

        public Builder withOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
            this.outcomeOdds = outcomeOdds;

            return this;
        }

        public Builder withBet(Bet bet){
            this.bet = bet;

            return this;
        }

        public Outcome build() {
            Outcome outcome = new Outcome();

            outcome.description = this.description;
            outcome.outcomeOdds = this.outcomeOdds;
            outcome.bet = this.bet;

            return outcome;
        }
    }
}
