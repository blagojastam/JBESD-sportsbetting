package com.epam.training.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Getter
@Setter
public class BettingAccount extends DomainEntity {

    String ID = String.valueOf(ThreadLocalRandom.current().nextInt(10000000, 99999999));

    @Enumerated(EnumType.STRING)
    Currency currency;

    double balance;

    @OneToOne
    Player owner;
}
