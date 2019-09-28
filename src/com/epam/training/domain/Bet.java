package com.epam.training.domain;

import java.util.List;

public class Bet {
    String description;
    BetType type;
    SportEvent event;
    List<Outcome> outcomes;
}
