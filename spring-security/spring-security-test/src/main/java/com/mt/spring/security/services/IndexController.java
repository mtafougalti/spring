package com.mt.spring.security.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "Hello World !";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome ! ";
	}

}
