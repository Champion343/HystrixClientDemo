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
	    URI uri = URI.create("18.221.160.51:8081/api/hystrixdemo/hello");

	    return restTemplate.getForObject(uri, String.class);
	}
	
	public String reliable() {
		return "reliable hello";
	}
	
}
