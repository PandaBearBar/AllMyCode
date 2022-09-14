package com.BarSpring2.demo.lab1.Beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
@Data
public class Cat {
    @Value("${Cat.name}")
    private String name;
    @Autowired
    private Chip chip;
}
