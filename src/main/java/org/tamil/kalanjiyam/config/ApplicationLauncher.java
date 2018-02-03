package org.tamil.kalanjiyam.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.tamil.kalanjiyam.repository")
public class ApplicationLauncher {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLauncher.class, args);
	}
	
}