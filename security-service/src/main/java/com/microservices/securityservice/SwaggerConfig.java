package com.microservices.securityservice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {

	private Gateway gateway;

	private Map<String, AuthParameter> paramters = new LinkedHashMap<>();

	public static class Gateway {

		private String serviceId;

		private String prefix;

		public String getServiceId() {
			return serviceId;
		}

		public void setServiceId(String serviceId) {
			this.serviceId = serviceId;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
	}

	public static class AuthParameter {

		private String description;

		private String in;

		private boolean required;

		private String type;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIn() {
			return in;
		}

		public void setIn(String in) {
			this.in = in;
		}

		public boolean isRequired() {
			return required;
		}

		public void setRequired(boolean required) {
			this.required = required;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}

	public Map<String, AuthParameter> getParamters() {
		return paramters;
	}

	public void setParamters(Map<String, AuthParameter> paramters) {
		this.paramters = paramters;
	}

	public Gateway getGateway() {
		return gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}

}
