package com.epam.training.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public abstract class SportEvent extends DomainEntity {

    String title;

    LocalDateTime startDate;

    LocalDateTime endDate;

    @OneToOne
    Outcome outcome;
}
