package com.epam.training.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {
    BigDecimal amount;
    LocalDateTime timestampCreated;
    Boolean processed;
    Boolean win;
    Player player;
    Currency currency;

    public Wager() {
        timestampCreated = LocalDateTime.now();
    }
}
