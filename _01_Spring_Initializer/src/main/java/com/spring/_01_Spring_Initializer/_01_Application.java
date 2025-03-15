package com.spring._01_Spring_Initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class _01_Application {

	public static void main(String[] args) {
		SpringApplication.run(_01_Application.class, args);
		System.out.println("Running Ok");
	}

}
