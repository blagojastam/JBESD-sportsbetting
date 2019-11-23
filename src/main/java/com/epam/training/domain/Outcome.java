package com.epam.training.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;

    @OneToMany(mappedBy = "outcome", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutcomeOdd> outcomeOdds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bet_id")
    private Bet bet;

    public Outcome() {

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
        private String description;
        private List<OutcomeOdd> outcomeOdds;
        private Bet bet;

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
