package com.logan.SpringBootDemo.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

    public void code(){
        System.out.println("Coding in laptop");
    }
}
