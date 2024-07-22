package com.example.cashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashcardApplication.class, args);
        doTheThing();
	}
    
    private static void doTheThing() {
        System.out.println("Fuck");
    }

}

