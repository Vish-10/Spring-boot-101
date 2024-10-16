package com.logan.SpringJDBC;

import com.logan.SpringJDBC.model.Student;
import com.logan.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Student s1 = context.getBean(Student.class);
		s1.setRollno(101);
		s1.setMarks(75);
		s1.setName("Logan");

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s1);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
