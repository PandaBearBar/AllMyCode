package com.bar.demo1.bins.studentNteacher;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
@Primary
public class Ronu implements Teacher {
    @Override
    public void name() {
        System.out.println("Its Ronu");
    }
}
