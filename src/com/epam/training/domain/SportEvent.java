package com.epam.training.domain;

import java.time.LocalDateTime;
import java.util.List;

public abstract class SportEvent {
    String title;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Result result;
    List<Bet> bets;
}
