package com.candy.intelligencedemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.candy.intelligencedemo1")
public class IntelligenceDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(IntelligenceDemo1Application.class, args);
	}
}
