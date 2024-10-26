package com.logan.SpringDataJPA;

import com.logan.SpringDataJPA.model.Student;
import com.logan.SpringDataJPA.repo.StudentRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		StudentRepo repo = context.getBean(StudentRepo.class);

		s1.setRollno(101);
		s1.setMarks(75);
		s1.setName("Test1");

		s2.setRollno(102);
		s2.setMarks(80);
		s2.setName("Test2");

		s3.setRollno(103);
		s3.setMarks(85);
		s3.setName("Test3");

		repo.save(s1);//saving a new data

		System.out.println(repo.findAll());

		//search by primary key
		Optional<Student> ts1 = repo.findById(101);//findbyid returns a type of optional ie. it can have null too
		System.out.println(ts1.orElse(new Student()));

		Optional<Student> ts2 = repo.findById(105);//findbyid returns a type of optional ie. it can have null too
		System.out.println(ts2.orElse(new Student()));

		//search by name
		System.out.println(repo.findByName("Test1"));

		//update
		//.save can be used to update the record

		//delete
		//.delete can be used
	}

}
