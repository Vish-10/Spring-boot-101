package com.logan.QuizService.controller;

import com.logan.QuizService.model.QuestionWrapper;
import com.logan.QuizService.model.QuizDto;
import com.logan.QuizService.model.Response;
import com.logan.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    //http://localhost:8080/quiz/create?category=Java&num=2&title=CQuiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        System.out.println("QuizDta" + quizDto);
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
    }

    @GetMapping("{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int quizId){
        return quizService.getQuizQuestions(quizId);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
