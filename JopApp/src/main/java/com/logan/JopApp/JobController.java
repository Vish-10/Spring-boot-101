package com.logan.JopApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

    @RequestMapping({"/", "/home"}) //this is made into an array because we have to map both the urls to the home page
    public String home(){
        System.out.println("home page called");
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(){
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(){
        return "viewalljobs";
    }

}
