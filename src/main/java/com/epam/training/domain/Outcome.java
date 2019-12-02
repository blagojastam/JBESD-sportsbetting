package com.epam.training.domain;

import javax.persistence.Entity;

@Entity
public class Outcome extends DomainEntity {
    String winner;
    String result;
}
