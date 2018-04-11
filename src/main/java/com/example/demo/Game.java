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
    public int 
}
