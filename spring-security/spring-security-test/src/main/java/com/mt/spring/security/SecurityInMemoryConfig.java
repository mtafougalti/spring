package com.mt.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SecurityInMemoryConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(bcpEncoder()).withUser("admin").password("$2a$10$peSwAOqLEywCiPVIaT3LI.tdO6QNJeBFrbyxY0dF3YCvDvqKFdNQm").roles("ADMIN", "USER");
		auth.inMemoryAuthentication().passwordEncoder(bcpEncoder()).withUser("user").password("$2a$10$peSwAOqLEywCiPVIaT3LI.tdO6QNJeBFrbyxY0dF3YCvDvqKFdNQm").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
		.antMatchers("/tasks").hasRole("ADMIN")
		.and().formLogin(); 
	}
	
	@Bean
	public BCryptPasswordEncoder bcpEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
