package com.example.demo.controller;

import com.example.demo.Database;
import com.example.demo.Game;
import com.example.demo.GameStart;
import com.example.demo.Run;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    GameStart player = new GameStart();

    @GetMapping("/Difficulty.html")
    public ModelAndView showDifficulty() {
        return new ModelAndView("Difficulty.html");
    }

    //EASY
    @GetMapping("/MainGamePageEasy.html")
    public ModelAndView startEasy() throws SQLException {
        String dbTable = "dbo.EasyWordList";

        player.setCounter(1);

        int counter = player.getCounter();

        String imagePath = database.getImg(dbTable, counter);
        return new ModelAndView("MainGamePageEasy.html").addObject("img",
                imagePath);
    }

    /*@GetMapping("/lolnewpage")
    public ModelAndView playEasy() {
        return new ModelAndView("MainGamePageEasy.html");
    }*/

    @PostMapping("/WordInputEasy")
    public ModelAndView inputWord(@RequestParam String input) throws SQLException {
        String dbTable = "dbo.EasyWordList";
        String correct = database.getWord(dbTable, player.getCounter());
        System.out.println(correct);

        boolean test = game.stringComparator(input, correct);
        if (test) {
            player.setCounter(player.getCounter()+1);
            int counter = player.getCounter();
            String imagePath = database.getImg(dbTable, counter);
            return new ModelAndView("/MainGamePageEasy.html").addObject("img", imagePath);
        }
        else {
            return new ModelAndView("redirect:/Fail.html");
        }
    }
    //EASY

     @GetMapping("/Fail.html")
     public ModelAndView showGameOver() {
         return new ModelAndView("Fail.html");
     }

    @GetMapping("/MainGamePage.html")
    public ModelAndView showMainGamePage() {
        return new ModelAndView("MainGamePage.html");
    }



}