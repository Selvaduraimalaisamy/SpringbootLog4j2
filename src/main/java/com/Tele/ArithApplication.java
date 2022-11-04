package com.Tele;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.Tele")
public class ArithApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArithApplication.class, args);
	}

}
