package com.microservices.gateway;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.node.ObjectNode;

@FeignClient(name="security-service")
@RibbonClient(name="security-service")
public interface LoginClient {

	@GetMapping("/login")
	String login(@RequestParam("user") String user, @RequestParam("password") String password);
	
	@GetMapping("/api-docs/{serviceId}")
	ObjectNode getDocs(@PathVariable String serviceId);
}
