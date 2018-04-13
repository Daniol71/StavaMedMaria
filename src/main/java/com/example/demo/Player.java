package com.example.demo;

public class Player {

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int counter;

    /*public enum Difficulty {
        EASY, MEDIUM, HARD
    }

    String dbTable = "";

    Difficulty difficulty;

    public String setDifficulty(Difficulty difficulty) {
        switch (difficulty) {

            case EASY:
                dbTable = "dbo.EasyWordList";
                break;

            case MEDIUM:
                dbTable = "dbo.MediumWordlist";
                break;

            case HARD:
                dbTable = "dbo.HardWordlist";
                break;
        }
        return dbTable;
    }*/
}
