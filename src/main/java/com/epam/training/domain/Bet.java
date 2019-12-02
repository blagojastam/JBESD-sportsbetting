package com.epam.training.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
public class Bet extends DomainEntity {

    @OneToOne
    Player player;

    @OneToOne
    SportEvent sportEvent;

    double amount;

    @Enumerated(EnumType.STRING)
    Currency currency;

    boolean processed;


}
