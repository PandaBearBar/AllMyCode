package com.BarSpring2.demo.lab2.Config;

import com.BarSpring2.demo.lab2.Beans.MyPrototype;
import com.BarSpring2.demo.lab2.Beans.MySingleton;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.BarSpring2.demo.lab2")

public class MyConfiguration {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MyPrototype protoSix() {
        MyPrototype myPrototype = new MyPrototype();
        myPrototype.setX(6);
        return myPrototype;
    }
    @Bean
    @Lazy
    public MySingleton singleSix(){
        MySingleton mySingleton = new MySingleton();
        mySingleton.setX(6);
        return mySingleton;
    }
}
