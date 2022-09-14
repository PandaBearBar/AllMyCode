package com.jb.BarSpring.Beans;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Scope("Prototype")

public class Person {
    @Value("${Person.id}")
    private int id;
    @Value("Moshe")
    private String name;
}

