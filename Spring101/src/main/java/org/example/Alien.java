package org.example;

public class Alien {
    int age;
    private int age1;
    private Laptop lap;//alien shouldn't be dependent on laptop so therefore we make a new interface called computer that will be extended by laptop and something like desktop
    //we can create a Computer object and later based upon the object value that com has the respective function will be called

    private  Computer com;
    public Alien(){
        System.out.println("Alien constructor");
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        System.out.println("setter called");
        this.age1 = age1;
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        System.out.println("Coding");
    }

    public void code1(){
        System.out.println("Coding 1 called");
        lap.compile();
    }

    public void code2(){
        System.out.println("Coding 2 called");
        com.compile();
    }
}
