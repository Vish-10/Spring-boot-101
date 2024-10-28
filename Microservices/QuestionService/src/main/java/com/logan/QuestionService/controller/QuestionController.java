package com.logan.QuestionService.controller;

import com.logan.QuestionService.model.Question;
import com.logan.QuestionService.model.QuestionWrapper;
import com.logan.QuestionService.model.Response;
import com.logan.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/")
    public ResponseEntity<String> addQuestion(@RequestBody Question newQuestion){
        return questionService.addQuestion(newQuestion);
    }

    //we have to have a method to generate questions so that the quiz service can get the questions
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions){
        System.out.println("controller" + categoryName + numQuestions);
       return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }


    //we have to have a method to get a questions based on a question id
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromIds(questionIds);
    }

    //get score
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
