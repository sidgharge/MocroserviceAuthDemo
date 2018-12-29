package com.microservices.securityservice.config;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {

	private Gateway gateway;

	private AuthParameters paramters = new AuthParameters();

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

	public static class AuthParameters {

		private Map<String, Parameter> includes = new LinkedHashMap<>();

		private Set<String> excludes = new LinkedHashSet<>();

		public static class Parameter {

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

		public Map<String, Parameter> getIncludes() {
			return includes;
		}

		public void setIncludes(Map<String, Parameter> includes) {
			this.includes = includes;
		}

		public Set<String> getExcludes() {
			return excludes;
		}

		public void setExcludes(Set<String> excludes) {
			this.excludes = excludes;
		}

	}

	public AuthParameters getParamters() {
		return paramters;
	}

	public void setParamters(AuthParameters paramters) {
		this.paramters = paramters;
	}

	public Gateway getGateway() {
		return gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}

}
