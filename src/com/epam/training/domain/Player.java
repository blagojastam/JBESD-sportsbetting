package com.epam.training.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Player extends User {
    String name;
    int accountNumber;
    BigDecimal balance;
    LocalDateTime birth;
    Currency currency;
}
