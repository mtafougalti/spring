package com.mt.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ProductsConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsConfigServiceApplication.class, args);
	}

}
