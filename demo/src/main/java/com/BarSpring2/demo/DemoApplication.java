package com.BarSpring2.demo;

import com.BarSpring2.demo.lab1.Beans.Cat;
import com.BarSpring2.demo.lab1.Beans.Person;
import com.BarSpring2.demo.lab1.Beans.School.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		Person p1 = ctx.getBean(Person.class);
		System.out.println(p1);

		Cat c1 = ctx.getBean(Cat.class);
		Cat c2 = ctx.getBean(Cat.class);
		System.out.println(c1 +"\n" + c2);

		Student s1 = ctx.getBean(Student.class);
		System.out.println(s1);
	}

}
