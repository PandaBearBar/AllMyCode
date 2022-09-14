package com.bar.demo1.bins.prototypeNsingletone.conf;

import com.bar.demo1.bins.prototypeNsingletone.bins.myPrototype;
import com.bar.demo1.bins.prototypeNsingletone.bins.mySingleton;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class myComposed {
    @Autowired
    @Qualifier("myPrototype")
    private myPrototype p1;

    @Autowired
    @Qualifier("portoSix")
    private myPrototype p2;

    @Autowired
    @Qualifier("mySingleton")
    private mySingleton s1;

    @Autowired
    @Qualifier("singleSix")
    private mySingleton s2;

    @Override
    public String toString(){
        return "MyComposed =\n" +
                " p1 = " + p1 +
                " ,p2 = " + p2 +
                " ,s1 = " + s1 +
                " ,s2 = " + s2;
    }
}
