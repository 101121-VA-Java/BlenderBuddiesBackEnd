package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.UserRepository;
import com.revature.exceptions.UserNotFoundException;
//import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
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
		// bunch of logic
		ur.save(u);
	}

	public List<User> getUserByRole(Role role) {
		return ur.findUsersByRole(role);
//		return null;
	}

	// bad practice, for example's sake. Use real dao layer
//	private List<User> users = new ArrayList<>();
//	
//	public UserService() {
//		// Creating 2 users in our arrayList
//		User a = new User();
//		a.setUserId(1);
//		a.setUsername("BigK");
//		a.setPassword("Kpass");
//		a.setFirstName("Kevin");
//		a.setLastName("Tranhu");
//		a.setEmail("Kevin@gmail.com");
//		a.setRole(new Role(1, "Admin"));
//		
//		User b = new User();
//		b.setUserId(2);
//		b.setUsername("BadOne");
//		b.setPassword("Bpass");
//		b.setFirstName("Brayden");
//		b.setLastName("Whitlock");
//		b.setEmail("Brayden10@gmail.com");
//		b.setRole(new Role(1, "User"));
//		
//		users.add(a);
//		users.add(b);
//	}
//	
//	public List<User> getAllUsers(){
//		return users;
//	}
//	
//	public User getUserById(int id) {
//		for(User u : users) {
//			if(u.getUserId() == id) {
//				return u;
//			}
//		}
//		// throw a custom exception
//		throw new UserNotFoundException();
//	}
//	
//	public void createUser(User u) {
//		users.add(u);
//	}
//	
//	public List<User> getUserByRole(Role role){
//		List<User> temp = new ArrayList<>();
//		for(User u:users) {
//			if(u.getRole().equals(role)) {
//				temp.add(u);
//			}
//		}
//		
//		return temp;
//	}
}
