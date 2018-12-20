package com.microservices.securityservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam("user") String user) {
		return user + ":123";
	}
}
