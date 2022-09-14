package com.bar.demo1.bins.prototypeNsingletone.bins;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@Lazy
public class mySingleton {
    private int x = (int) (Math.random()*101);
}
