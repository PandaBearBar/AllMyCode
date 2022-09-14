package com.BarSpring2.demo.lab2.Beans;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
@Data
public class MySingleton {
    private int x = (int) (Math.random() * 101);

    public MySingleton() {
        System.out.println("MySingleton - CTOR IN ACTION");
    }

    @PostConstruct
    public void init() {
        System.out.println("MySingleton - Post Construct...");
    }

    @PreDestroy
    public void bye() {
        System.out.println("MySingleton - Pre Destroy...");
    }
}

