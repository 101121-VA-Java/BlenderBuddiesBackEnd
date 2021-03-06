package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.SimpleUser;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(exposedHeaders="Authorization")
public class AuthController {

	private AuthService as;
	
	@Autowired
	public AuthController(AuthService as) {
		this.as = as;
	}
	
	@PostMapping
	public ResponseEntity<SimpleUser> login(@RequestParam(name="username")String username, @RequestParam(name="password")String password){
		SimpleUser sUser = as.login(username, password);
		
		String token = as.generateToken(sUser);
		
		// setting headers to be returned to the front end
		HttpHeaders hh = new HttpHeaders();
		
		hh.set("Authorization", token);
		
		// constructor for response entity(body, headers, status)
		return new ResponseEntity<>(sUser, hh, HttpStatus.OK);
	}
}