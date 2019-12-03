package com.epam.training.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class PossibleOutcome extends DomainEntity {

    @OneToOne
    SportEvent sportEvent;

    @Enumerated(EnumType.STRING)
    OutcomeType outcomeType;

    String winner;
    int numberOfGoals;
    String playerScored;
    int setsPlayed;

    double ratio;
}
