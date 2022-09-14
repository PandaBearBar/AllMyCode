package com.bar.demo1.bins.catNchip;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
public class Cat {
    @Value("Mitizi")
    private String name;
    @Autowired
    private Chip chip;
}
