package com.epam.training.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class BettingAccount extends DomainEntity {
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    Currency currency;

    double balance;

    @OneToOne
    Player owner;
}
