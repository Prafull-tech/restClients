package com.m3bi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.m3bi.clientApp.ClientComponent;
import com.m3bi.clientApp.RestClient;
import com.m3bi.clientApp.Student;

@SpringBootApplication
public class Ms4Rest1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Ms4Rest1Application.class, args);
		//RestClient bean = ctx.getBean(RestClient.class);
		//Student currencyCost = bean.getCurrencyCost("USD", "INR");
		//ResponseEntity<Student> student = bean.postStudent(new Student(110, "Maknish", "MS"));
		//System.out.println(student.getBody());

		ClientComponent bean = ctx.getBean(ClientComponent.class);
		bean.invokeRestApi("USD", "INR");
		ctx.close();
		
	}

}
