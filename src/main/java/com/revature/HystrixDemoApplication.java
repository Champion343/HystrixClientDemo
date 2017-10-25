package com.revature;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.service.HelloService;

@RefreshScope
@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class HystrixDemoApplication {

	private static final Logger LOG = Logger.getLogger(HystrixDemoApplication.class.getName()); // Gets a logger for this class

	public static void main(String[] args) {
		SpringApplication.run(HystrixDemoApplication.class, args);
	}
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping("/hi")
	public String callHello(){
		LOG.log(Level.INFO, "\"/hi\" endpoint accessed in Hystrix Client Demo."); // prints an entry to the log
		return helloService.hello();
	}
}
