package com.BarSpring2.demo.lab1.Beans.School;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@Primary
public class Roni implements Teacher{
    @Override
    public void printName() {
        System.out.println("Roni");
    }
}
