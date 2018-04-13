package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {
    @Autowired
    Database database;

    //Metod som kollar att stavningen är korrekt
    public boolean stringComparator(String input, String correct){
        correct = correct.trim();
        input = input.trim();
        input = input.toLowerCase();

        int correctLength = correct.length();
        int inputLength = input.length();

        if(inputLength==correctLength) {
            if (input.equals(correct)) {
                return true;
            }
        }
        return false;
    }
}
