package com.preTest.demo8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.preTest.demo8"},
		excludeFilters =
@ComponentScan.Filter(type = FilterType.ASPECTJ,
		pattern = "com.preTest.demo8.clr.off.*"))
@EnableScheduling
public class Demo8Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo8Application.class, args);
	}

}
