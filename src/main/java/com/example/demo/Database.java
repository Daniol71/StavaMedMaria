package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

    //TEST METHOD
    public static void viewTable(Connection con, String dbName)
            throws SQLException {
        Statement stmt = null;
        String query = "select *" +
                "from " + dbName + ".Wordlist1";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String word = rs.getString("Word");
                String difficulty = rs.getString("DifficultyLevel");

                System.out.println(id + "\t" + word +
                        "\t" + difficulty + "\t");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    //TEST METHOD

    public List<String> getWordSet(Connection con, String dbTable, String difficulty)
            throws SQLException {
        String word = "";
        List<String> words = new ArrayList<>();
        Statement stmt = null;
        String query = "select *" + "from " + dbTable + " where " + "DifficultyLevel = " + "'" + difficulty + "';";

        try {
            stmt = con.createStatement();
            ResultSet wordSet = stmt.executeQuery(query);
            while (wordSet.next()) {
                word = wordSet.getString("Word");
                words.add(word);
            }
            System.out.println(words);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return words;
    }
}