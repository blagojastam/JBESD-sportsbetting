package com.epam.training.domain;

import java.time.LocalDateTime;

public abstract class SportEvent {
    String title;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Result result;
}
