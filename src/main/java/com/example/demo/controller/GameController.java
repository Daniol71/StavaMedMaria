package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    @GetMapping("/Difficulty.html")
    public ModelAndView showDifficulty(){
        return new ModelAndView("Difficulty.html");
    }

    @GetMapping("/MainGamePage.html")
    public ModelAndView showMainGamePage(){
        return new ModelAndView("MainGamePage.html");
    }
}
