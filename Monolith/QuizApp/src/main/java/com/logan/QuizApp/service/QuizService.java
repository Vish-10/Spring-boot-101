package com.logan.QuizApp.service;

import com.logan.QuizApp.dao.QuestionDao;
import com.logan.QuizApp.dao.QuizDao;
import com.logan.QuizApp.model.Question;
import com.logan.QuizApp.model.QuestionWrapper;
import com.logan.QuizApp.model.Quiz;
import com.logan.QuizApp.model.Response;
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
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int num, String title) {
        try{
            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, num);
            Quiz newQuiz = new Quiz();
            System.out.println("returned questions" + questions);
            newQuiz.setQuestions(questions);
            newQuiz.setTitle(title);
            System.out.println("new quiz: " + newQuiz);
            quizDao.save(newQuiz);

            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int quizId) {
        try{
            Quiz quiz = quizDao.findById(quizId).orElse(new Quiz());//this returns object of type Optional
            List<Question> questionsFromDB = quiz.getQuestions();
            //now we have to convert question to question wrapper

            List<QuestionWrapper> questions = new ArrayList<>();
            for(Question q: questionsFromDB){
                QuestionWrapper tempQues = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questions.add(tempQues);
            }

            return new ResponseEntity<>(questions, HttpStatus.OK);

        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
