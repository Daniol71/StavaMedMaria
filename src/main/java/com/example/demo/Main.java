package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication

public class Main implements CommandLineRunner {
	@Qualifier("dataSource")
	@Autowired
	DataSource dataSource;

	public Main() throws SQLException {
	}
	Database db = new Database();

	public void run(String... strings) throws SQLException {
		Connection dbconn= dataSource.getConnection();
		db.getWordSet(dbconn, "dbo.WordList1", "hard");
	}

	public static void main(String[] args){
			SpringApplication.run(Main.class, args);
	}
}
