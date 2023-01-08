package com.teja.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HelloDemoApplication {

	private static final Logger LOGGER = LogManager.getLogger(HelloDemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HelloDemoApplication.class, args);
		System.out.println("Hello World");
	}

}
