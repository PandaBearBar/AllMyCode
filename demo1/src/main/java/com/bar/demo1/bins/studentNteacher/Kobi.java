package com.bar.demo1.bins.studentNteacher;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class Kobi implements Teacher{
    @Override
    public void name() {
        System.out.println("Its Kobi");
    }
}
