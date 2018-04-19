package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;

@Component
public class Database {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    public String getWord(String dbTable,int index)
            throws SQLException {
        String word = "";
        Statement stmt = null;

        //Add prepared statement

        String query = "select Word " + "from " + dbTable + " where " + "ID= " + "'" + index + "';";

        try(Connection con = dataSource.getConnection()) {
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
        String img = "";
        Statement stmt = null;
        String query = "select Image " + "from " + dbTable + " where " + "ID= " + "'" + index + "';";
        try(Connection con = dataSource.getConnection()) {
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
}