package com.microservices.userservice;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

	@GetMapping("/exc/{num}")
	public String throwExceptionOnOddNum(@PathVariable int num) {
		String resp = "Got: " + num + " from port: " + port;
		logger.error(resp);
		if (port == 8085 && num % 2 != 0) {
			throw new RuntimeException(resp);
		}
		return resp;
	}
}
