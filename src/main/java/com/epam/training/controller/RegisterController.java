package com.epam.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @PostMapping("/register")
    public String register() {

        return "index";
    }

    @PostMapping("/bax")
    public String bax() {

        return "index";
    }
}
