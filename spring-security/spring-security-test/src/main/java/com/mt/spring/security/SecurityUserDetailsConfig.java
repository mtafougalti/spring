package com.mt.spring.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mt.spring.security.dto.UserDto;
import com.mt.spring.security.entities.User;


public class SecurityUserDetailsConfig extends WebSecurityConfigurerAdapter{
	
	private static Map<String, User> usersMap = new HashMap<>();
	static {
		usersMap.put("admin", new User(1L, "admin", "{noop}test", "", true, Arrays.asList("ROLE_ADMIN", "ROLE_USER")));
		usersMap.put("user", new User(1L, "user", "{noop}test", "", true, Arrays.asList("ROLE_USER")));
	}
	
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
			User user = usersMap.get(username);
			if(user != null)
				return new UserDto(usersMap.get(username));
			else
				throw new RuntimeException("Credentials not valid");
		};
	}

}
