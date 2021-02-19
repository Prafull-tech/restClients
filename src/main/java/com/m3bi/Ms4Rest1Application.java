package com.m3bi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.m3bi.clientApp.RestClient;
import com.m3bi.clientApp.Student;

@SpringBootApplication
public class Ms4Rest1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Ms4Rest1Application.class, args);
		RestClient bean = run.getBean(RestClient.class);
		//Student currencyCost = bean.getCurrencyCost("USD", "INR");
		ResponseEntity<Student> student = bean.postStudent(new Student(110, "Maknish", "MS"));
		System.out.println(student.getBody());
	}

}
