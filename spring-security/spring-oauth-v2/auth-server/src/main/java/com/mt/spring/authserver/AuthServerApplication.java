package com.mt.spring.authserver;

import com.mt.spring.authserver.model.AppUser;
import com.mt.spring.authserver.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class AuthServerApplication {

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			appUserRepository.save(new AppUser(null, "user", passwordEncoder.encode("test"), true, Arrays.asList("ROLE_USER")));
			appUserRepository.save(new AppUser(null, "admin", passwordEncoder.encode("test"), true, Arrays.asList("ROLE_ADMIN")));

			appUserRepository.findAll().forEach(
					user -> {
						System.out.println(user);
					}
			);
		};
	}

}
