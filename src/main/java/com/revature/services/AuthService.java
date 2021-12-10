package com.revature.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserRepository;
import com.revature.dtos.SimpleUser;
import com.revature.exceptions.LoginException;
import com.revature.models.User;

@Service
public class AuthService {

	private UserRepository ur;

	@Autowired
	public AuthService(UserRepository ur) {
		this.ur = ur;
	}

	public SimpleUser login(String username, String password) {
		User u = ur.findUserByUsername(username);
		// authentication logic: does the password match what is in the database/ is the
		// user present in the database
		if (u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return new SimpleUser(u);
	}

	public String generateToken(SimpleUser sUser) {
		/*
		 * Insert logic to generate a Token here
		 */
		String token = sUser.getUserId() + ":" + sUser.getRole();

		return token;
	}
}
