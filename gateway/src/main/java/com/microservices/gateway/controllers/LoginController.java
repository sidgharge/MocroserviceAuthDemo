package com.microservices.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.gateway.LoginClient;

@RestController
public class LoginController {
	
	@Autowired LoginClient loginClient;

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam("user") String user, @RequestParam("password") String password) {
		if (user.equalsIgnoreCase(password)) {
			String token = loginClient.login(user, password);
			return new ResponseEntity<>(token, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
		}
	}
}
