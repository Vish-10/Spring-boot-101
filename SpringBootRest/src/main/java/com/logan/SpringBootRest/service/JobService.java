package com.logan.SpringBootRest.service;

import com.logan.SpringBootRest.model.JobPost;
import com.logan.SpringBootRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    public void addJob(JobPost job){
        repo.addJobPost(job);
    }

    public List<JobPost> getAllJobs(){
        System.out.println("service called");
        return repo.getAllJobs();
    }

    public JobPost getJob(int jobId){
        return repo.getJob(jobId);
    }

    public JobPost updateJob(JobPost jobPost) {
        return repo.updateJob(jobPost);
    }

    public String deleteJob(int jobId) {
        return repo.deleteJob(jobId);
    }
}
