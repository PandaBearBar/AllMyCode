package com.BarSpring2.demo.lab2.Beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.geom.Path2D;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class MyComposed {
    @Autowired
    @Qualifier("myPrototype")
    private MyPrototype p1;

    @Autowired
    @Qualifier("protoSix")
    private MyPrototype p2;

    @Autowired
    @Qualifier("mySingleton")
    private MySingleton s1;

    @Autowired
    @Qualifier("singleSix")
    private MySingleton s2;

    public MyComposed() {
        System.out.println("MyComposed - CTRO IN ACTION");
    }

    public MyPrototype getP1() {
        return p1;
    }

    public void setP1(MyPrototype p1) {
        this.p1 = p1;
    }

    public MyPrototype getP2() {
        return p2;
    }

    public void setP2(MyPrototype p2) {
        this.p2 = p2;
    }

    public MySingleton getS1() {
        return s1;
    }

    public void setS1(MySingleton s1) {
        this.s1 = s1;
    }

    public MySingleton getS2() {
        return s2;
    }

    public void setS2(MySingleton s2) {
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return "MyComposed [p1=" + p1 + ", p2=" + p2 + ", s1=" + s1 + ", s2=" + s2 + "]";
    }
}
