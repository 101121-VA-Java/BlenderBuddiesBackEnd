package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.UserRepository;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.RoleEnum;
import com.revature.models.User;

@Service
public class UserService {

	private UserRepository ur;

	@Autowired
	public UserService(UserRepository ur) {
		this.ur = ur;
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}

	public User getUserById(int id) {
		return ur.findById(id).orElseThrow(UserNotFoundException::new);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createUser(User u) {

		ur.save(u);
	}

	public List<User> getUserByRole(RoleEnum role) {
		return ur.findUsersByRole(role);

	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(int id, User u) {
		User temp = ur.getById(id);
		temp.setFirstName(u.getFirstName());
		temp.setLastName(u.getLastName());
		temp.setEmail(u.getEmail());
		temp.setUsername(u.getUsername());
		temp.setPassword(u.getPassword());
		ur.save(temp);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateRole(int id) {
		User temp = ur.getById(id);
		if (temp.getRole().equals(RoleEnum.USER)) {
			temp.setRole(RoleEnum.ADMIN);
		}else {
			temp.setRole(RoleEnum.USER);
		}
		ur.save(temp);
	}
}
