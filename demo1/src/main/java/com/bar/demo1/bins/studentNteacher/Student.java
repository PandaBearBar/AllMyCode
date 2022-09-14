package com.bar.demo1.bins.studentNteacher;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
public class Student {

    @Value("123")
    private int id;
    @Value("Student")
    private String name;
    @Value("A")
    private String profession;
    @Autowired
    @Qualifier("kobi")
    private Teacher teacher;
}
