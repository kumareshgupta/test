package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getMessage() {
		return "Welcome To ES";		
	}
	@RequestMapping(value="/allemployees", method=RequestMethod.GET)
	public String getEmployees() {
		String response = restTemplate.exchange("http://localhost:8667/employees", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
		}).getBody();
		return response;		
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
