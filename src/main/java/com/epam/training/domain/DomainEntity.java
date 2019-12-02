package com.epam.training.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public abstract class DomainEntity {

    @Id
    UUID ID = UUID.randomUUID();

    LocalDateTime createdAt = LocalDateTime.now();
}
