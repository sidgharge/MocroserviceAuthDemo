package com.microservices.gateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.microservices.gateway.fiegnclients.LoginClient;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class LoginController {

	@Autowired
	LoginClient loginClient;

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam("user") String user, @RequestParam("password") String password) {
		if (user.equalsIgnoreCase(password)) {
			String token = loginClient.login(user, password);
			return new ResponseEntity<>(token, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
		}
	}

	@ApiIgnore
	@GetMapping("/docs/{serviceId}")
	public ObjectNode getDocs(@PathVariable String serviceId) {
		return loginClient.getDocs(serviceId);
	}
}
