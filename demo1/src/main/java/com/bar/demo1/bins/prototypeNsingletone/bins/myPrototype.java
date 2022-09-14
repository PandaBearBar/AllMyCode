package com.bar.demo1.bins.prototypeNsingletone.bins;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
@Component
@NoArgsConstructor

public class myPrototype {
    private int x = (int) (Math.random()*101);
}
