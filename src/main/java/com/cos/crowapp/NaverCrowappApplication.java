package com.cos.crowapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NaverCrowappApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverCrowappApplication.class, args);
	}

}
