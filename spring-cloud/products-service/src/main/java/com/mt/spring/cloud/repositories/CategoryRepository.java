package com.mt.spring.cloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.mt.spring.cloud.model.Category;

@RepositoryRestController
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
