package com.epam.training.domain;

import java.util.List;

public class Outcome {
    String description;
    List<OutcomeOdd> outcomeOdds;
    Bet bet;

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
