package com.mayank.tech.learnrediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LearnrediscacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnrediscacheApplication.class, args);
	}

}
