package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static com.example.demo.Database.viewTable;

@SpringBootApplication

public class Main implements CommandLineRunner {
	@Autowired
	DataSource dataSource;

	public Main() throws SQLException {
	}

	public void run(String... strings) throws SQLException {
		Connection dbconn= dataSource.getConnection();
		viewTable(dbconn, "dbo");}

	public static void main(String[] args){
			SpringApplication.run(Main.class, args);
	}
}
