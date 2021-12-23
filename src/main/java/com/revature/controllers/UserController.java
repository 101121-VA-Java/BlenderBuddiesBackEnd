package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.RoleEnum;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	private UserService us;
	
	// constructor injection, Spring will use this constructor to handle the dependency with UserService
	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers(@RequestParam(name="role", required = false)RoleEnum role){
		// if a query param of name "role" is passed in, returns users of this role
		if(role != null) {
			return us.getUserByRole(role);
		}
		return us.getAllUsers();
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id")int id) {
		return new ResponseEntity<>(us.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping 
	public ResponseEntity<String> createUser(@Valid @RequestBody User user){
		us.createUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id")int id, @Valid @RequestBody User user, @RequestParam(name="role", required = false)RoleEnum role){
		if(role != null) {
			us.updateRole(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		us.updateUser(id, user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
