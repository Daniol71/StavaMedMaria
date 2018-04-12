package com.example.demo.controller;

import com.example.demo.Database;
import com.example.demo.Game;
import com.example.demo.Run;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class GameController {

    @Autowired
    Game game;
    @Autowired
    Run run;


    @GetMapping("/Difficulty.html")
    public ModelAndView showDifficulty(){
      /*  try {
            run.test();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return new ModelAndView("Difficulty.html");
    }

    @GetMapping("/MainGamePage.html")
    public ModelAndView showMainGamePage(){
        return new ModelAndView("MainGamePage.html");
    }
    @PostMapping("/WordInput")
    public ModelAndView inputWord(@RequestParam String input, String correct ){ game.stringComparator(input, correct);
        return new ModelAndView("WordInput");
    }
}
