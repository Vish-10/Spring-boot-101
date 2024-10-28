package com.logan.QuestionService.dao;

import com.logan.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String catergory);

    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int num);
}
