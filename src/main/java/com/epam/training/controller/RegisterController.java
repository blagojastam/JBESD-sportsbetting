package com.epam.training.controller;

import com.epam.training.domain.Player;
import com.epam.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class RegisterController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/signup")
    public ModelAndView signup(String email, String username, String password, String confirmPassword,
                               String firstName, String lastName, String birthDate, Model model) {



        if (!password.equals(confirmPassword)) {
            return new ModelAndView("register");
        }

        else {
            Player newPlayer = new Player();
            newPlayer.setName(firstName + " " + lastName);
            newPlayer.setEmail(email);
            newPlayer.setPassword(password);

            String[] dates = birthDate.split("-");
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int day = Integer.parseInt(dates[2]);

            newPlayer.setBirthdate(LocalDateTime.of(year, month, day, 0, 0));
            newPlayer.setUsername(username);
            playerService.saveNew(newPlayer);

            return new ModelAndView("login");
        }
    }
}
