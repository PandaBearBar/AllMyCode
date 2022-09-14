package com.BarSpring2.demo.lab1.Beans.School;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Student {
    @Value("123")
    private int id;
    @Value("Bar")
    private String name;
    @Value("Devop")
    private String Profession;
    @Qualifier("kobi")
    @Autowired
    private Teacher teacher;
   // private Teacher kobi;
}
