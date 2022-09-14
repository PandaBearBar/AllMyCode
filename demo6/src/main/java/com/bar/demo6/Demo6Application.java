package com.bar.demo6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bar.demo6"},
		excludeFilters =
		@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.bar.demo6.clr.off.*"))
@EnableScheduling
public class Demo6Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo6Application.class, args);
	}

}
