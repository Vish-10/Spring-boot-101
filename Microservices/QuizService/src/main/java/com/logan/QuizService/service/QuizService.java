package com.logan.QuizService.service;

//import com.logan.QuizService.dao.QuestionDao;
import com.logan.QuizService.dao.QuizDao;
import com.logan.QuizService.feign.QuizInterface;
import com.logan.QuizService.model.Question;
import com.logan.QuizService.model.QuestionWrapper;
import com.logan.QuizService.model.Quiz;
import com.logan.QuizService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String categoryName, int numQuestions, String title) {
        try{
            System.out.println("Inside Create 1 "+ categoryName);
            List<Integer> questions = quizInterface.getQuestionsForQuiz(categoryName, numQuestions).getBody();//getBody is used coz we are returning a response entity from the question service
            System.out.println(questions);
            Quiz newQuiz = new Quiz();
            newQuiz.setTitle(title);
            newQuiz.setQuestionsIds(questions);
            quizDao.save(newQuiz);
            System.out.println("Inside Create saved");

            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int quizId) {
        try{
            Quiz quiz = quizDao.findById(quizId).get();//this returns object of type Optional
            List<Integer> questionIds = quiz.getQuestionsIds();
            ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);

            return questions;

        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
