package com.revature.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
	@HystrixCommand(fallbackMethod = "reliable")
	public String hello() {
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://localhost:8088/hello");

	    return restTemplate.getForObject(uri, String.class);
	}
	
	public String reliable() {
		return "reliable hello";
	}
	
}
