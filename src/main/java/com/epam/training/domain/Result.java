package com.epam.training.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "bet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Outcome> winnerOutcomes;

    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public void setWinnerOutcomes(List<Outcome> winnerOutcomes) {
        this.winnerOutcomes = winnerOutcomes;
    }
}
