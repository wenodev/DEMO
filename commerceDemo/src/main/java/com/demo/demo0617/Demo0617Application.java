package com.demo.demo0617;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Demo0617Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0617Application.class, args);
	}

}
