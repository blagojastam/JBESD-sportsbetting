package com.epam.training.controller;

import com.epam.training.domain.BettingAccount;
import com.epam.training.domain.Player;
import com.epam.training.service.BettingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DetailsController {
    @Autowired
    BettingAccountService bettingAccountService;

    @GetMapping("/details")
    public ModelAndView details() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Player currentPlayer = (Player)principal;

        ModelAndView mav = new ModelAndView("details");
        mav.addObject("currentPlayer", currentPlayer);

        List<BettingAccount> playerBettingAccounts = bettingAccountService.findAllForPlayer(currentPlayer);
        mav.addObject("playerAccounts", playerBettingAccounts);

        return mav;
    }

    @PostMapping("/deposit")
    public ModelAndView deposit(String accountId, String deposit) {
        BettingAccount account = bettingAccountService.findById(accountId).get();
        bettingAccountService.DepositToAccount(Double.parseDouble(deposit), account);


        return details();
    }
}
