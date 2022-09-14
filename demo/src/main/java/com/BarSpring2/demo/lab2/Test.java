package com.BarSpring2.demo.lab2;

import com.BarSpring2.demo.lab2.Beans.MyComposed;
import com.BarSpring2.demo.lab2.Beans.MyPrototype;
import com.BarSpring2.demo.lab2.Beans.MySingleton;
import com.BarSpring2.demo.lab2.Config.MyConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        System.out.println("START");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyPrototype p1 = ctx.getBean("myPrototype", MyPrototype.class);
        MyPrototype p2 = ctx.getBean("myPrototype", MyPrototype.class);
        MySingleton s1 = ctx.getBean("mySingleton", MySingleton.class);
        MySingleton s2 = ctx.getBean("mySingleton", MySingleton.class);
        MyPrototype sixer1 = ctx.getBean("protoSix", MyPrototype.class);
        MyPrototype sixer2 = ctx.getBean("protoSix", MyPrototype.class);
        MySingleton sixerSin1 = ctx.getBean("singleSix", MySingleton.class);
        MySingleton sixerSin2 = ctx.getBean("singleSix", MySingleton.class);
        /*
        MyPrototype p1 = ctx.getBean(MyPrototype.class);
        MyPrototype p2 = ctx.getBean(MyPrototype.class);
        MySingleton s1 = ctx.getBean(MySingleton.class);
        MySingleton s2 = ctx.getBean(MySingleton.class);
        MyPrototype sixer1 = ctx.getBean(MyPrototype.class);
        MyPrototype sixer2 = ctx.getBean(MyPrototype.class);
        MySingleton sixerSin1 = ctx.getBean(MySingleton.class);
        MySingleton sixerSin2 = ctx.getBean(MySingleton.class);
         */ // there is a need for Primary as well !
        System.out.println(p1.getX());
        System.out.println(p2.getX());
        System.out.println(s1.getX());
        System.out.println(s2.getX());
        System.out.println(sixer1.getX());
        System.out.println(sixer2.getX());
        System.out.println(sixerSin1.getX());
        System.out.println(sixerSin2.getX());
        MyComposed c1 = ctx.getBean(MyComposed.class);
        System.out.println(c1.getP1().getX());
        System.out.println(c1.getP2().getX());
        System.out.println(c1.getS1().getX());
        System.out.println(c1.getS2().getX());
        MyComposed c2 = ctx.getBean(MyComposed.class);
        System.out.println(c2);
        ((AnnotationConfigApplicationContext) ctx).close();
        System.out.println("End");
    }
}
