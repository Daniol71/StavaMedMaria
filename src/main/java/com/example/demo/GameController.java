package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class GameController {

    @Autowired
    Game game;
    @Autowired
    Database database;

    Player player = new Player();

    @GetMapping("/")
    public ModelAndView showStart() {
        player.setCounter(1);
        return new ModelAndView("index.html");
    }

    @GetMapping("/Difficulty.html")
    public ModelAndView showDifficulty() {
        return new ModelAndView("Difficulty.html");
    }

    //EASY
    @GetMapping("/MainGamePageEasy.html")
    public ModelAndView startEasy() throws SQLException {

        String dbTable = "dbo.EasyWordList";
        int counter = player.getCounter();
        String imagePath = database.getImg(dbTable, counter);

        return new ModelAndView("MainGamePageEasy.html").addObject("img",
                imagePath);
    }

    @PostMapping("/WordInputEasy")
    public ModelAndView inputWordEasy(@RequestParam String input) throws SQLException {

        String dbTable = "dbo.EasyWordList";
        String correct = database.getWord(dbTable, player.getCounter());

        boolean test = game.stringComparator(input, correct);
        if (player.getCounter()==5 && test){
            return new ModelAndView("/Win.html");
        }
        else if (test) {
            player.incrementCounter();
            int counter = player.getCounter();
            String imagePath = database.getImg(dbTable, counter);
            return new ModelAndView("/MainGamePageEasy.html").addObject("img", imagePath);
        }
        else {
            return new ModelAndView("/Fail.html");
        }
    }
    //EASY

    //MEDIUM
    @GetMapping("/MainGamePageMedium.html")
    public ModelAndView startMedium() throws SQLException {

        String dbTable = "dbo.MediumWordList";
        int counter = player.getCounter();
        String imagePath = database.getImg(dbTable, counter);

        return new ModelAndView("MainGamePageMedium.html").addObject("img",
                imagePath);
    }

    @PostMapping("/WordInputMedium")
    public ModelAndView inputWordMedium(@RequestParam String input) throws SQLException {

        String dbTable = "dbo.MediumWordList";
        String correct = database.getWord(dbTable, player.getCounter());

        boolean test = game.stringComparator(input, correct);
        if (player.getCounter()==5 && test){
            return new ModelAndView("/Win.html");
        }
        else if (test) {
            player.incrementCounter();
            int counter = player.getCounter();
            String imagePath = database.getImg(dbTable, counter);
            return new ModelAndView("/MainGamePageMedium.html").addObject("img", imagePath);
        }
        else {
            return new ModelAndView("/Fail.html");
        }
    }
    //MEDIUM

    //HARD
    @GetMapping("/MainGamePageHard.html")
    public ModelAndView startHard() throws SQLException {

        String dbTable = "dbo.HardWordList";
        int counter = player.getCounter();
        String imagePath = database.getImg(dbTable, counter);

        return new ModelAndView("/MainGamePageHard.html").addObject("img",
                imagePath);
    }

    @PostMapping("/WordInputHard")
    public ModelAndView inputWordHard(@RequestParam String input) throws SQLException {

        String dbTable = "dbo.HardWordList";
        String correct = database.getWord(dbTable, player.getCounter());

        boolean test = game.stringComparator(input, correct);
        if (player.getCounter()==5 && test){
            return new ModelAndView("/Win.html");
        }
        else if (test) {
            player.incrementCounter();
            int counter = player.getCounter();
            String imagePath = database.getImg(dbTable, counter);
            return new ModelAndView("/MainGamePageHard.html").addObject("img", imagePath);
        }
        else {
            return new ModelAndView("/Fail.html");
        }
    }
    //HARD

    @GetMapping("/Fail.html")
    public ModelAndView showGameOver() {
         return new ModelAndView("Fail.html");
     }

    @GetMapping("/Win.html")
    public ModelAndView showWin() {
        return new ModelAndView("Win.html");
    }
}