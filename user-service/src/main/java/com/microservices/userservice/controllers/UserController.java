package com.microservices.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.userservice.models.User;

@RestController
public class UserController {

	@GetMapping("/{name}")
	public String greet(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@PostMapping("/{name}")
	public String greetPost(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@PostMapping("")
	public User user(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
	
}
