package com.epam.training.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
public class FinalOutcome extends DomainEntity {

    @OneToOne
    SportEvent sportEvent;

    String winner;

    int numberOfGoals;

    @ElementCollection
    List<String> playerScored;

    int setsPlayed;
}
