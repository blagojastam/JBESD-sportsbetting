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
public class BettingAccount extends DomainEntity {

    @Enumerated(EnumType.STRING)
    Currency currency;

    double balance;

    @OneToOne
    Player owner;
}
