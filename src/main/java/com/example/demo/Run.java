package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class Run {
    @Autowired
    Game game;
    @Autowired
    Database database;


    public void test() throws SQLException {
        database.viewTable("dbo");
    }


}
