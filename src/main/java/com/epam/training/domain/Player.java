package com.epam.training.domain;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Player extends User {
    String name;

    LocalDateTime birthdate;

}
