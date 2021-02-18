package com.m3bi.clientApp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {

	String endPointUrl = "http://localhost:8081/currency/USD/to/INR";
	String endPointForPostReq = "http://localhost:8081/save";

	RestTemplate rt = new RestTemplate();

	public Student getCurrencyCost(String from,String to) {

		ResponseEntity<Student> responseEntity = rt.getForEntity(endPointUrl, Student.class,from,to);
		if (responseEntity!=null && responseEntity.getStatusCode().value()==200) {
			return responseEntity.getBody();
		}
		return null;
	}

	/**
	 * Rest Template For Post Request 
	 */
	public ResponseEntity<Student> postStudent() {

		HttpHeaders header = new HttpHeaders();
		header.add("Accept", "application/json");
		header.add("ContentType", "application/json");
		HttpEntity<Student> reqEntity = new HttpEntity<Student>(new Student(105,"Prafull Kumar","SE"),header);
		ResponseEntity<Student> postForEntity = rt.postForEntity(endPointForPostReq, reqEntity, Student.class);
		return (ResponseEntity<Student>) postForEntity;
	}
}
