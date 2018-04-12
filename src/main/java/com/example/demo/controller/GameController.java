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
    @Autowired
    Database database;

    String dbTable = "dbo.EasyWordList";
    int counter = 1;

    @GetMapping("/Difficulty.html")
    public ModelAndView showDifficulty() {
        return new ModelAndView("Difficulty.html");
    }

    @GetMapping("/MainGamePageEasy.html")
    public ModelAndView setEasy() throws SQLException {


        String imagePath = database.getImg(dbTable, counter);

        return new ModelAndView("MainGamePageEasy.html").addObject("img",
                imagePath);
    }

    @GetMapping("/MainGamePage.html")
    public ModelAndView showMainGamePage() {
        return new ModelAndView("MainGamePage.html");
    }


    @PostMapping("/WordInput")
    public ModelAndView inputWord(@RequestParam String input) throws SQLException {
        String correct = database.getWord(dbTable, counter);

        boolean test = game.stringComparator(input, correct);
        if (test) {
            counter++;
            return new ModelAndView("redirect:/MainGamePageEasy.html");
        } else {
            return new ModelAndView("redirect:/MainGamePageEasy.html");
        }
    }
}