package com.logan.JopApp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data //this is a part of lombok that creates the getters and setters
@Component
public class JobPost {

    private int postId;
    private String postProfile;
    private String jobDesc;
    private int reqExperience;
    private List<String> postTechStack;


}
