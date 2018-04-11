package com.example.demo;

public class Game {



    /*public boolean inputValidator(String input) {
        input = input.trim();
        if (input == null || input.isEmpty()) {
            return false;
        }
        if (input.matches("0123456789")){

        }
        return true;
    }*/

    //Metod som kollar att stavningen är korrekt
    public boolean stringComparator(String input, String correct){
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
