package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LeaveTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveTrackerApplication.class, args);
	}

}
