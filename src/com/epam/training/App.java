package com.epam.training;

import com.epam.training.service.SportsBetingServiceImpl;
import com.epam.training.service.SportsBettingService;
import com.epam.training.view.View;

public class App {

    SportsBettingService service;
    View view;

    public App(SportsBettingService service, View view) {
        this.service = new SportsBetingServiceImpl();
        this.view = view;
    }

    public static void main(String[] args) {
	// write your code here
    }

    public void play() {

    }
}
