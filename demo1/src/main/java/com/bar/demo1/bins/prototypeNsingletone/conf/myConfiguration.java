package com.bar.demo1.bins.prototypeNsingletone.conf;


import com.bar.demo1.bins.prototypeNsingletone.bins.myPrototype;
import com.bar.demo1.bins.prototypeNsingletone.bins.mySingleton;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.bar.demo1.bins")
public class myConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public myPrototype portoSix(){
        myPrototype myPrototype = new myPrototype();
        myPrototype.setX(6);
        return myPrototype;
    }
    @Bean
    @Lazy
    public mySingleton singleSix(){
        mySingleton mySingleton = new mySingleton();
        mySingleton.setX(6);
        return mySingleton;
    }



}
