package com.bar.demo1.bins.person;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.BeanDescriptor;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
@Data
public class Person {
    @Value("Moshe")
    private String name;
    @Value("${Person.Id}")
    private int id;
}
