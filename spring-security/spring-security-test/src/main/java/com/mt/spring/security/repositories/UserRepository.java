package com.mt.spring.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.spring.security.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByUsername(String username);

}
