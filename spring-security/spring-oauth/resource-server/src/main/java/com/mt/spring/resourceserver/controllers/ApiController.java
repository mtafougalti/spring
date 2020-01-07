package com.mt.spring.resourceserver.controllers;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/hello")
	@PreAuthorize("#oauth2.hasScope('read')")
	public ResponseEntity<String> helloUser(Principal principal) {
		return new ResponseEntity<>("Hello " + principal.getName(), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<Principal> user(Principal principal) {
		return new ResponseEntity<>(principal, HttpStatus.OK);
	}
	
	@GetMapping("/welcome")
	@PreAuthorize("#oauth2.hasScope('write')")
	public ResponseEntity<String> welcome(Principal principal) {
		return ResponseEntity.ok("Welcome " + principal.getName());
	}

}
