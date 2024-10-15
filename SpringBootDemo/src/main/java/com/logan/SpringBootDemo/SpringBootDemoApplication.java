package com.logan.SpringBootDemo;

import com.logan.SpringBootDemo.model.Laptop;
import com.logan.SpringBootDemo.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);//this returns the object of a class that extends the application context

		//this is how we generally call the function
//		Alien obj = new Alien();
//		obj.code();

		//DI using spring boot
		//IoC container can give us the object only if it has the object
		//for this purpose we use annotations
//		Alien obj1 = context.getBean(Alien.class);//so here we are asking the IoC container to give us the object for alien class
//		obj1.code();
//		obj1.code2();

		LaptopService service = context.getBean(LaptopService.class);

		Laptop lap = context.getBean(Laptop.class);
		service.addLaptop(lap);
	}

}
