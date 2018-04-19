package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication

public class Main {

	public static void main(String[] args) {
		Maria maria = new Maria();
		Random plsGiveMeAHead = new Random();
		maria.hasHead = plsGiveMeAHead.nextBoolean();
		if(maria.hasHead)
			System.out.println(maria.happyFace);
		else
			System.out.println(maria.sadFace);
		SpringApplication.run(Main.class, args);
	}
}
