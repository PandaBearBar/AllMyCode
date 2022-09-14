package com.bar.demo1.bins.catNchip;


import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class Chip {
    UUID chipId = UUID.randomUUID();
}
