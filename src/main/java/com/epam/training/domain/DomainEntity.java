package com.epam.training.domain;

import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class DomainEntity {

    @Id
    String ID = UUID.randomUUID().toString();

    LocalDateTime createdAt = LocalDateTime.now();
}
