package com.logan.QuizService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//this is to enable RestTemplate so that the quiz service can make a request to the question service
public class QuizServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuizServiceApplication.class, args);
	}

}
