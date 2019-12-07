package com.mt.spring.cloud.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mt.spring.cloud.model.Product;

@RestController
public class ProductGatewayService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/products")
	public Collection<Product> getProducts(){
		ParameterizedTypeReference<CollectionModel<Product>> responseType = new ParameterizedTypeReference<CollectionModel<Product>>() {
		};
		Collection<Product> products = restTemplate.exchange("http://localhost:9999/products-service/products", HttpMethod.GET, null, responseType).getBody().getContent();
		return products;
	}

}
