package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class GameController {

    @Autowired
    Game game;
    @Autowired
    Database database;

    @GetMapping("/")
    public ModelAndView showStart() {
        return new ModelAndView("index.html");
    }

    @GetMapping("/Difficulty")
    public ModelAndView showDifficulty() {
        return new ModelAndView("Difficulty.html");
    }

    @GetMapping("/MainGamePage")
    public ModelAndView startEasy(@RequestParam String level, HttpSession session)
            throws SQLException {

        String dbTable = "dbo.EasyWordList";

        switch (level) {
            case "easy":
                dbTable = "dbo.EasyWordList";
                session.setAttribute("table", dbTable);
                break;
            case "medium":
                dbTable = "dbo.MediumWordList";
                session.setAttribute("table", dbTable);
                break;
            case "hard":
                dbTable = "dbo.HardWordList";
                session.setAttribute("table", dbTable);
                break;
        }

        int counter = 1;
        session.setAttribute("index", counter);
        String imagePath = database.getImg(dbTable, counter);

        return new ModelAndView("MainGamePage.html").addObject("img",
                imagePath);
    }

    @PostMapping("Game")
    public ModelAndView inputWordEasy(@RequestParam String input, HttpSession session) throws SQLException {
        String dbTable = session.getAttribute("table").toString();
        int counter = (int) session.getAttribute("index");
        String correct = database.getWord(dbTable, counter);

        boolean test = game.stringComparator(input, correct);
        if (counter == 5 && test) {
            session.invalidate();
            return new ModelAndView("/Win.html");
        } else if (test) {
            session.setAttribute("index", counter + 1);
            counter = (int) session.getAttribute("index");
            String imagePath = database.getImg(dbTable, counter);
            return new ModelAndView("/MainGamePage.html").addObject("img", imagePath);
        } else {
            session.invalidate();
            return new ModelAndView("/Fail.html");
        }
    }
}