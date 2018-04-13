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

    //Metod som räknar poäng för nivå easy
    public int countingPointsEasy(boolean correctSpell, int counter){

        if (correctSpell==true){
            counter++;
        }
        return counter;
    }


    //Metod som räknar poäng för nivå Medium
    public int countingPointsMedium(boolean correctSpell, int counter) {

        if (correctSpell==true){
            counter = counter+2;
        }
        return counter;
    }

    //Metod som räknar poäng för nivå Hard
    public int countingPointsHard(boolean correctSpell, int counter) {

        if (correctSpell==true){
            counter = counter+3;
        }
        return counter;
    }


}
