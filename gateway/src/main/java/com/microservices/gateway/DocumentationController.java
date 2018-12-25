package com.microservices.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {

	@Autowired
	private LoginClient loginClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${security-application-name}")
	private String securityAppName;

	@Override
	public List<SwaggerResource> get() {
		return discoveryClient.getServices().stream().filter(serviceId -> !applicationName.equalsIgnoreCase(serviceId)
				&& !securityAppName.equalsIgnoreCase(serviceId)).map(serviceId -> {
					return swaggerResource(serviceId, "/docs/" + serviceId, "2.0");
				}).collect(Collectors.toList());
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
