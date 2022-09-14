package com.project.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.project2"},
		excludeFilters = @ComponentScan.Filter(
				type = FilterType.ASPECTJ,
				pattern = "com.project.project2.clr.off.*"
		)
)
@EnableScheduling
public class Project2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}
