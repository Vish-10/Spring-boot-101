package com.logan.SpringBootRest;

import com.logan.SpringBootRest.model.JobPost;
import com.logan.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    //@ResponseBody
    //by default using @Controller makes the application think we are returning a jsp ie. a view. so we add this to make sure we're returning a data so we add @ResponseBody
    //alternatively we can use @RestController instead of @Controller
    public List<JobPost> getAllJobs(){
        System.out.println("Controller called");
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId){
        //use the same name as in the getmapping

        return service.getJob(jobId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        return service.updateJob(jobPost);

    }

    @DeleteMapping("jobPost/{jobId}")
    public String deleteJob(@PathVariable("jobId") int jobId){
        return service.deleteJob(jobId);
    }
}
