package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //to use application context in a maven project we have to add it in the dependencies since applicationcontext is a part of spring framework
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //this is a xml
        //since we are using xml here we have to create a xml file

        Alien obj = (Alien) context.getBean("alien"); //getbean returns an object of type object so thats the reason we have to type cast it
        //usually the spring has a container called IoC Container that creates and holds the objects for us
        //but here we haven't mentioned anything about spring it is just a plain maven project
        obj.code();
    }
}
