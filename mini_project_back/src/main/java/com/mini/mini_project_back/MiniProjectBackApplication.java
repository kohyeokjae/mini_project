package com.mini.mini_project_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MiniProjectBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectBackApplication.class, args);
	}

}
