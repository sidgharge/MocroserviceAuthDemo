package com.microservices.securityservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class BeanConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	@Bean
//	public WebMvcConfigurer webMvcConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addResourceHandlers(ResourceHandlerRegistry registry) {
//				registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//
//				registry.addResourceHandler("/webjars/**")
//						.addResourceLocations("classpath:/META-INF/resources/webjars/");
//			}
//		};
//	}
}
