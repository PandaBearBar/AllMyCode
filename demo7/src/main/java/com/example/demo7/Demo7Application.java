package com.example.demo7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo7"},
		excludeFilters =
		@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.example.demo7.clr.off.*"))
@EnableScheduling
public class Demo7Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo7Application.class, args);
	}

}
