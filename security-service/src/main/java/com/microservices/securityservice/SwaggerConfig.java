package com.microservices.securityservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xmlpull.v1.XmlPullParserException;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	@Bean
//    public Docket api() throws IOException, XmlPullParserException {
//        return new Docket(DocumentationType.SWAGGER_2)
//          .select()
//          .apis(RequestHandlerSelectors.basePackage("com.microservices"))
//          .paths(PathSelectors.any())
//          .build();//.apiInfo(new ApiInfo("Account Service Api Documentation", "Documentation automatically generated", "v1", null, new Contact("Sid", "abc.com", "sid@gmail.com"), null, null));
//}
//
//	@Bean
//	public Docket swaggerPlugin() {
//		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).build()
//				.securitySchemes(Arrays.asList(apiKey()))
//				//.securityContexts(Arrays.asList(securityContext()))
//				.globalOperationParameters(operationParameters());
//	}
//
//	private List<Parameter> operationParameters() {
//		List<Parameter> headers = new ArrayList<>();
//		headers.add(new ParameterBuilder().name("HEADER_1").description("HEADER_1 DESC")
//				.modelRef(new ModelRef("string")).parameterType("header").required(false).build());
//
//		headers.add(new ParameterBuilder().name("HEADER_2").description("HEADER_2 DESC")
//				.modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("0").build());
//		return headers;
//	}
//
//	@Bean
//	SecurityConfiguration security() {
//		return new SecurityConfiguration(null, null, null, null, "Bearer access_token", ApiKeyVehicle.HEADER,
//				"Authorization", ",");
//	}
//	
//	private ApiKey apiKey() {
//        return new ApiKey("Authorization", "Authorization", "header");
//    }
}
