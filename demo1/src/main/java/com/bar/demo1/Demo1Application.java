package com.bar.demo1;


import com.bar.demo1.bins.catNchip.Cat;
import com.bar.demo1.bins.person.Person;
import com.bar.demo1.bins.prototypeNsingletone.bins.myPrototype;
import com.bar.demo1.bins.prototypeNsingletone.bins.mySingleton;
import com.bar.demo1.bins.prototypeNsingletone.conf.myComposed;
import com.bar.demo1.bins.studentNteacher.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Demo1Application.class, args);

		Person p1 = ctx.getBean(Person.class);
		System.out.println(p1);

		Cat c1 = ctx.getBean(Cat.class);
		System.out.println(c1);

		Student s1 = ctx.getBean(Student.class);
		System.out.println(s1);

		myComposed co1 = ctx.getBean(myComposed.class);
		System.out.println(co1.getP1().getX());
		System.out.println(co1.getP2().getX());
		System.out.println(co1.getS1().getX());
		System.out.println(co1.getS2().getX());

		myComposed co2 = ctx.getBean(myComposed.class);
		System.out.println(co2);
	}

}
