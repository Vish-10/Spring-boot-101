package com.logan.SpringJDBC.service;

import com.logan.SpringJDBC.model.Student;
import com.logan.SpringJDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s1) {
       repo.save(s1);
    }


    public List<Student> getStudents() {
        return repo.findAll();
    }
}
