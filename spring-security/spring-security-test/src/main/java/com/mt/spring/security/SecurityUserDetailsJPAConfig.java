package com.mt.spring.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mt.spring.security.dto.UserDto;
import com.mt.spring.security.entities.User;
import com.mt.spring.security.repositories.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityUserDetailsJPAConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getUserDetailsService());
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
	public UserDetailsService getUserDetailsService() {
		return username -> {
			Optional<User> user = userRepository.findByUsername(username);
			if(user.isPresent())
				return new UserDto(user.get());
			else
				throw new UsernameNotFoundException("Credentials not valid");
		};
	}

}
