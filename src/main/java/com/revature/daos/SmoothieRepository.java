package com.revature.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.RoleEnum;
import com.revature.models.Smoothie;
import com.revature.models.User;

@Repository
public interface SmoothieRepository extends JpaRepository<Smoothie, Integer>{

	List<Smoothie> findSmoothiesByTypeAndUser(RoleEnum type, User user);
	List<Smoothie> findSmoothiesByNameIgnoreCase(String name);
}
