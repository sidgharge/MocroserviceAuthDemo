package com.microservices.moduleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ModuleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleServiceApplication.class, args);
	}

}

