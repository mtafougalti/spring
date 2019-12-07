package com.mt.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ProductsEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsEurekaServiceApplication.class, args);
	}

}
