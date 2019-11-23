package com.epam.training.controller;

import com.epam.training.domain.Player;
import com.epam.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

    @Autowired
    PlayerService playerService;

    @GetMapping({"/", "/index"})
    public String index(){
        return "index.jsp";
    }

    @PostMapping("/login")
    public ModelAndView index(@RequestParam("email") String email,
                              @RequestParam("password") String password){
        ModelAndView mav = null;

        Player foundPlayer = playerService.findByEmail(email).get();

        if (foundPlayer != null && foundPlayer.getPassword().equals(password)) {
            mav = new ModelAndView("hello.jsp");
            mav.addObject("name", foundPlayer.getName());
        } else {
            mav = new ModelAndView("register.jsp");
        }

        return mav;
    }

}
