package com.example.demo0518;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Demo0518Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0518Application.class, args);
	}

}
