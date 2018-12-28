package com.microservices.userservice;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${server.port}")
	private int port;

	@GetMapping("greet/{name}")
	public String greet(@PathVariable String name) {
		return "Hello " + name + " from port: " + port;
	}
	
	@GetMapping("/ping")
	public void ping() {
		System.out.println(LocalDateTime.now() + "Pinging in user service at port: " + port);
	}
}
