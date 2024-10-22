package com.logan.SpringBootRest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data //this is a part of lombok that creates the getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {

    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;


}
