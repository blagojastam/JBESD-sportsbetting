package com.epam.training.controller;

import com.epam.training.domain.Bet;
import com.epam.training.domain.Player;
import com.epam.training.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    BetService betService;

    @GetMapping("/")
    public ModelAndView index() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Player currentPlayer = (Player)principal;

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPlayer", currentPlayer);

        List<Bet> playerBets = betService.findAllForPlayer(currentPlayer);
        mav.addObject("playerBets", playerBets);
        mav.addObject("sequence",1);

        return mav;
    }

    @PostMapping ModelAndView deleteBet(String betId) {
        Bet toDelete = betService.findById(betId).get();
        betService.delete(toDelete);

        return index();
    }
}
