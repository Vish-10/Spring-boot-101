package com.logan.SpringBootDemo.repo;

import com.logan.SpringBootDemo.model.Laptop;
import org.springframework.stereotype.Repository;

//adding annotations like component will work same applies for service
@Repository
public class LaptopRepository {

    public void save(Laptop lap){
        System.out.println("Saving laptop to database");
    }
}
