package com.logan.SpringBootDemo.service;

import com.logan.SpringBootDemo.repo.LaptopRepository;
import com.logan.SpringBootDemo.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repo;
    public void addLaptop(Laptop lap){
        System.out.println("Add called");
        repo.save(lap);
    }

    public boolean isGoodForProg(Laptop lap){
        return true;
    }
}
