package com.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EnableEurekaClient
public class ProductHandingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductHandingApplication.class, args);
	}
@Bean 
public CommonsMultipartResolver commonmultipartresolver() {
	return new  CommonsMultipartResolver(); 
}
@Bean
RestTemplate resttemplete() {
	return new RestTemplate();
}
}
