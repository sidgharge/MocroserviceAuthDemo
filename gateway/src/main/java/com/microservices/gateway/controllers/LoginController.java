package com.microservices.gateway.controllers;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.microservices.gateway.AuthHeader;
import com.microservices.gateway.LoginClient;

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

	@GetMapping("/docs/{serviceId}")
	public ObjectNode getDocs(@PathVariable String serviceId) {
		return loginClient.getDocs(serviceId);
	}
}
