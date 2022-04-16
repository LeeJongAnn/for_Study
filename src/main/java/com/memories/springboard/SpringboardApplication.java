package com.memories.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboardApplication.class, args);
	}

}