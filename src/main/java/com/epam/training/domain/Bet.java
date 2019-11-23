package com.epam.training.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private BetType type;

    @OneToMany(mappedBy = "bet", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Outcome> outcomes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event")
    private SportEvent event;

    public Bet() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }

    public static class Builder {
        private String description;
        private BetType type;
        private SportEvent event;
        private List<Outcome> outcomes;

        public Builder(String description) {
            this.description = description;
        }

        public Builder withType(BetType type) {
            this.type = type;

            return this;
        }

        public Builder withOutcomes(List<Outcome> outcomes) {
            this.outcomes = outcomes;

            return this;
        }

        public Builder withEvent(SportEvent event){
            this.event = event;

            return this;
        }

        public Bet build() {
            Bet bet = new Bet();

            bet.event = this.event;
            bet.description = this.description;
            bet.type = this.type;
            bet.outcomes = this.outcomes;

            return bet;
        }
    }
}
