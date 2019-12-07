package com.mt.spring.cloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.mt.spring.cloud.model.Product;
import com.mt.spring.cloud.repositories.ProductRepository;

@EnableEurekaClient
@SpringBootApplication
public class ProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return (args) -> {
			productRepository.save(new Product("produit 1", "description du produit 1", 10));
			productRepository.save(new Product("produit 2", "description du produit 2", 15));
			productRepository.save(new Product("produit 3", "description du produit 3", 5));
			
			productRepository.findAll().forEach(p -> {
				System.out.println(p.getName());
			});
		};
	}

}
