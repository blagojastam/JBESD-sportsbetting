package com.epam.training.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public abstract class SportEvent extends DomainEntity {

    String title;

    LocalDateTime startDate;

    LocalDateTime endDate;

    @Column(name = "dtype", insertable = false, updatable = false)
    String type;
}
