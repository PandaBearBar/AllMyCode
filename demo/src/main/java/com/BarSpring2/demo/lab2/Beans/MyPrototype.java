package com.BarSpring2.demo.lab2.Beans;


import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class MyPrototype {
    private int x = (int)(Math.random()*101);

    public MyPrototype() {
        System.out.println("MyPrototype - CTOR IN ACTION");
    }
    @PostConstruct
    public void init(){
        System.out.println("MyPrototype - Post Construct...");
    }
    @PreDestroy
    public void bye(){
        System.out.println("MyPrototype - Pre  Construct...");
    }



}
