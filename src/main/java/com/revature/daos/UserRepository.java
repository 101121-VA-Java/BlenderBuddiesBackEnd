package com.revature.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.RoleEnum;
import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserByUsername(String name);
	List<User> findUsersByRole(RoleEnum role);
}
