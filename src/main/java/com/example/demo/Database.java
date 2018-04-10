package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

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
    } catch (SQLException e ) {
        e.printStackTrace();
    } finally {
        if (stmt != null) { stmt.close(); }
    }
}
}
