package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class Database {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    //TEST METHOD
    public void viewTable(String dbName)
            throws SQLException {
        Connection dbconn= dataSource.getConnection();
        Statement stmt = null;
        String query = "select *" +
                "from " + dbName + ".Wordlist";
        try {
            stmt = dbconn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String word = rs.getString("Word");
                String difficulty = rs.getString("DifficultyLevel");
                String image = rs.getString("Image");

                System.out.println(id + "\t" + word +
                        "\t" + difficulty + "\t" + image);
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

    public String getWord(String dbTable,int index)
            throws SQLException {
        Connection con = dataSource.getConnection();
        String word = "";
        Statement stmt = null;
        String query = "select Word " + "from " + dbTable + " where " + "ID= " + "'" + index + "';";

        try {
            stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                word = result.getString("Word");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return word;
    }

    public String getImg(String dbTable,int index)
            throws SQLException {
        Connection con = dataSource.getConnection();
        String img = "";
        Statement stmt = null;
        String query = "select Image " + "from " + dbTable + " where " + "ID= " + "'" + index + "';";

        try {
            stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                img = result.getString("Image");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return img;
    }

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