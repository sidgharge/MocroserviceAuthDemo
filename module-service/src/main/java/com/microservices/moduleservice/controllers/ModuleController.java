package com.microservices.moduleservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.moduleservice.models.Module;
import com.microservices.moduleservice.repositories.ModuleRepository;

@RestController
public class ModuleController {
	
	@Autowired
	private ModuleRepository moduleRepository;

	@GetMapping("/getmodule")
	public String getModule(@RequestHeader("username") String username) throws InterruptedException {
		Thread.sleep(3000);
		Module module = moduleRepository.findByUser(username);
		
		return module.getName();
	}
}
