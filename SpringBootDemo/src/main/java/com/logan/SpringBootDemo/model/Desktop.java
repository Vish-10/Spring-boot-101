package com.logan.SpringBootDemo.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{

    public void code(){
        System.out.println("Coding in desktop");
    }

}
