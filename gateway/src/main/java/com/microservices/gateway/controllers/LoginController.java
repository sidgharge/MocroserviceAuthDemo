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
	
	@Autowired LoginClient loginClient;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ZuulProperties zuul;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private AuthHeader header;

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
	
	@GetMapping("/api-docs/{serviceId}")
	public String getUserServiceDocs(@PathVariable String serviceId, HttpServletRequest request) {
		
		ObjectNode resNode = restTemplate.getForObject(buildSwaggerUrl(serviceId), ObjectNode.class);

		resNode.put("host", request.getHeader("host"));

		Map<String, ZuulRoute> routes = zuul.getRoutes();
		
		if (routes.get(serviceId).isStripPrefix()) {
			String prefix = getPrefix(routes, serviceId);

			ObjectNode pathsNode = (ObjectNode) resNode.path("paths");

			pathsNode.fields().forEachRemaining(entry -> addPrefixToApi(entry, prefix, pathsNode));
		}
		
		if (header.getName() != null) {
			ObjectNode pathsNode = (ObjectNode) resNode.path("paths");
			
			pathsNode.fields().forEachRemaining(this::addHeaderToApi);
		}

		return resNode.toString();
	}
	
	private String getPrefix(Map<String, ZuulRoute> routes, String serviceId) {
		String prefix = routes.get(serviceId).getPath().replaceAll("\\**", "");

		if (prefix.endsWith("/")) {
			prefix = prefix.substring(0, prefix.length() - 1);
		}
		
		return prefix;
	}
	
	private void addPrefixToApi(Entry<String, JsonNode> entry, String prefix, ObjectNode pathsNode) {
		String key = prefix + entry.getKey();
		JsonNode value = entry.getValue();
		pathsNode.remove(entry.getKey());
		pathsNode.set(key, value);
	}
	
	private void addHeaderToApi(Entry<String, JsonNode> entry) {
		ArrayNode arrayNode = (ArrayNode) entry.getValue().elements().next().get("parameters");
		ObjectNode newHeader = arrayNode.addObject();
		newHeader.put("name", header.getName());
		newHeader.put("in", "header");
		newHeader.put("description", header.getDescription());
		newHeader.put("required", false);
		newHeader.put("type", "string");
	}
	
	private String buildSwaggerUrl(String serviceId) {
		return discoveryClient.getInstances(serviceId).get(0).getUri() + "/v2/api-docs";
	}
	
	
}