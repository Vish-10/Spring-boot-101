package com.logan.SpringBootDemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Alien {

    @Value("25")
    private int age;//we're defaulting the value
    private Laptop laptop;

    private Computer computer;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    @Autowired
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Computer getComputer() {
        return computer;
    }

    @Autowired
    @Qualifier("laptop")
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void code(){
        laptop.code();
    }

    public void code2(){
        computer.code();
    }
}
