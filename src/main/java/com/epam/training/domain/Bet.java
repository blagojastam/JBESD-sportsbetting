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
public class Bet extends DomainEntity {

    @OneToOne
    Player player;

    @OneToOne
    PossibleOutcome possibleOutcome;

    @Enumerated(EnumType.STRING)
    Currency currency;

    double amount;

    boolean processed;

    boolean won;

    Integer number = sequence++;
    static Integer sequence = 1;
}
