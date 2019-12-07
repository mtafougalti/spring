package com.mt.spring.cloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.mt.spring.cloud.model.Product;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("select p from Product p where p.name like :keyWord")
	public List<Product> findProductsByKeyWord(@Param("keyWord") String keyWord);

}
