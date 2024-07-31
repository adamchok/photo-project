package com.project.photo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.photo.project")
@EnableJpaRepositories(basePackages = "com.project.photo.project.repository")
public class PhotoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoProjectApplication.class, args);
	}

}
