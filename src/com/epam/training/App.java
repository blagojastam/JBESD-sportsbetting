package com.epam.training;

import com.epam.training.domain.FootballSportEvent;
import com.epam.training.domain.SportEvent;
import com.epam.training.domain.TennisSportEvent;
import com.epam.training.service.SportsBettingServiceImpl;
import com.epam.training.service.SportsBettingService;
import com.epam.training.view.View;
import com.epam.training.view.ViewImpl;

public class App {

    SportsBettingService service;
    View view;

    public App(SportsBettingService service, View view) {
        this.service = new SportsBettingServiceImpl();
        this.view = new ViewImpl();
    }

    public static void main(String[] args) {
        SportEvent event = new SportEvent.Builder("football").buildFootballEvent();
        SportEvent two = new SportEvent.Builder("tennis").buildTennisEvent();

    }
    public void play() {

    }

    void createPlayer() {

    }

    void doBetting() {

    }

    void calculateResults() {

    }

    void printResults () {

    }
}
