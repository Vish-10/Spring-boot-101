package com.logan.QuizApp.controller;

import com.logan.QuizApp.model.Question;
import com.logan.QuizApp.model.QuestionWrapper;
import com.logan.QuizApp.model.Response;
import com.logan.QuizApp.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title){
        return quizService.createQuiz(category, num, title);
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
