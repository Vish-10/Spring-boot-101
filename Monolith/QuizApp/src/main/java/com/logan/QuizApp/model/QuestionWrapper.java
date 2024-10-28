package com.logan.QuizApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {
    //we create this class so that we send only the important informations to the client when they ask for all the questions in a quiz
    //example we shouldnt be sending the right answer
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
