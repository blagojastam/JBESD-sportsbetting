package com.epam.training.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SportEvent extends DomainEntity {

    String title;

    LocalDateTime startDate;

    LocalDateTime endDate;

    @OneToOne
    Outcome outcome;
}
