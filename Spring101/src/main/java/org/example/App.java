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
        //additional information: objects are created at this place - this refers to the xml file and creates all the objects that are mentioned there

        Alien obj = (Alien) context.getBean("alien"); //getbean returns an object of type object so thats the reason we have to type cast it
        //usually the spring has a container called IoC Container that creates and holds the objects for us
        //but here we haven't mentioned anything about spring it is just a plain maven project
        obj.code();

        Alien obj1 = (Alien) context.getBean("alien");
        Alien obj2 = (Alien) context.getBean("alien");
        /**
         * Here we may think that obj1 and obj2 are two diff objects
         * But they're the same objects
         */
        obj1.age = 21;
        System.out.println(obj1.age);
        System.out.println(obj2.age);

        //by default the scope is singleton
        //inorder to get a new object everytime getBean is called we have to change the scope to prototype(xml file)

        //setter injection
        Alien obj3 = (Alien) context.getBean("alien");
        //obj3.setAge1(33); //this is how we usually set the values
        //now we have to set the value using the property tag in the xml file
        //spring uses the setter method to inject the value
        System.out.println(obj3.getAge1());

        //this is for testing laptop object
        obj3.code1();

        //this is for testing interfaces
        obj3.code2();

        Desktop desktop = (Desktop) context.getBean("desktop");//this is for testing lazy-init



    }
}
