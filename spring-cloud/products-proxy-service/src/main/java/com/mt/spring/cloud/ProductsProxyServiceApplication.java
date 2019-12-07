package com.mt.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ProductsProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsProxyServiceApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
