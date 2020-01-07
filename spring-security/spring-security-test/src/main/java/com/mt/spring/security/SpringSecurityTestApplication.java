package com.mt.spring.security;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mt.spring.security.entities.Task;
import com.mt.spring.security.entities.User;
import com.mt.spring.security.repositories.TaskRepository;
import com.mt.spring.security.repositories.UserRepository;

@SpringBootApplication
public class SpringSecurityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(TaskRepository taskRepository, UserRepository userRepository) {
		return args -> {
			Stream.of("Task 1","Task 2","Task 3").forEach(t -> {
				taskRepository.save(new Task(null, t));
			});
			taskRepository.findAll().forEach(t -> {
				System.out.println("Task name : " + t.getName());
			});
			
			Stream.of(new User(1L, "admin", "{noop}test", "", true, Arrays.asList("ROLE_ADMIN", "ROLE_USER")),
					  new User(2L, "user", "{noop}test", "", true, Arrays.asList("ROLE_USER")))
			.forEach(user -> {
				 userRepository.save(user);
			});
			userRepository.findAll().forEach(user -> {
				System.out.println("User name : " + user.getUsername());
			});
		};
	}

}
