package com.BarSpring2.demo.lab1.Beans.School;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Component


@Data
@NoArgsConstructor
public class Kobi implements Teacher{
    @Override
    public void printName() {
        System.out.println("Kobi");
    }
}
