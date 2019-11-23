package com.epam.training.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SportEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    protected String title;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;

    @OneToOne
    protected Result result;

    @OneToMany(mappedBy = "event", cascade = CascadeType.MERGE, orphanRemoval = true)
    protected List<Bet> bets;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public static class Builder {
        private String title;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Result result;
        private List<Bet> bets;

        public Builder(String title) {
            this.title = title;
        }

        public Builder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;

            return this;
        }

        public Builder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;

            return this;
        }

        public Builder withResult(Result result) {
            this.result = result;

            return this;
        }

        public Builder withBets(List<Bet> bets) {
            this.bets = bets;

            return this;
        }

        public FootballSportEvent buildFootballEvent() {
            FootballSportEvent footballSportEvent = new FootballSportEvent();

            footballSportEvent.title = this.title;
            footballSportEvent.startDate = this.startDate;
            footballSportEvent.endDate = this.endDate;
            footballSportEvent.result = this.result;
            footballSportEvent.bets = this.bets;

            return footballSportEvent;
        }

        public TennisSportEvent buildTennisEvent() {
            TennisSportEvent tennisSportEvent = new TennisSportEvent();

            tennisSportEvent.title = this.title;
            tennisSportEvent.startDate = this.startDate;
            tennisSportEvent.endDate = this.endDate;
            tennisSportEvent.result = this.result;
            tennisSportEvent.bets = this.bets;

            return tennisSportEvent;
        }
    }
}
