package com.logan.SpringDataJPA.repo;

import com.logan.SpringDataJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    //the value inside the paranthesis is the class name and the primary key type

    @Query("select s from Student s where s.name = ?1")//the number after question mark indicates the paramenter number in the function
    List<Student> findByName(String studentName);
    //we write our own method and use query annotation to write the query
    //Note: here the query is jpql (JPA query language)
}
