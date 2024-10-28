package com.logan.QuestionService.service;


import com.logan.QuestionService.dao.QuestionDao;
import com.logan.QuestionService.model.Question;
import com.logan.QuestionService.model.QuestionWrapper;
import com.logan.QuestionService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question newQuestion) {
        try{
            questionDao.save(newQuestion);
            return new ResponseEntity<>("Added", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
        try{
            System.out.println("Inside generate");
            List<Integer> questionNumbers = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
            System.out.println(questionNumbers);
            return new ResponseEntity<>(questionNumbers, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> questionIds) {
        List<Question> questions = new ArrayList<>();
        List<QuestionWrapper> wrapperObject = new ArrayList<>();

        for(Integer id: questionIds){
            //questionDao.findById(id); -- this will return an optional object so we have to use get
            questions.add(questionDao.findById(id).get());
        }

        for(Question question: questions){
            QuestionWrapper temp = new QuestionWrapper();
            temp.setId(question.getId());
            temp.setQuestionTitle(question.getQuestionTitle());
            temp.setOption1(question.getOption1());
            temp.setOption2(question.getOption2());
            temp.setOption3(question.getOption3());
            temp.setOption4(question.getOption4());
            wrapperObject.add(temp);
        }

        return new ResponseEntity<>(wrapperObject, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int right = 0;

        for(Response response : responses){
            Question question = questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
