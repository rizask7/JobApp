package com.firstProject.JobApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.firstProject.JobApp"})
public class JobAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobAppApplication.class, args);
	}

}
