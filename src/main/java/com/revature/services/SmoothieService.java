package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.SmoothieRepository;
import com.revature.exceptions.SmoothieNotFoundException;
import com.revature.models.RoleEnum;
import com.revature.models.Smoothie;
import com.revature.models.User;

@Service
public class SmoothieService {
	private SmoothieRepository sr;
	
	@Autowired
	public SmoothieService(SmoothieRepository sr) {
		this.sr = sr;
	}
	
	public List<Smoothie> getAllSmoothies(){
		return sr.findAll();
	}
	
	public Smoothie getSmoothieById(int id) {
		return sr.findById(id).orElseThrow(SmoothieNotFoundException::new);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void createSmoothie(Smoothie s) {
		sr.save(s);
	}
	
	public List<Smoothie> getSmoothieByTypeAndUser(RoleEnum type, User user){
		return sr.findSmoothiesByTypeAndUser(type, user);
	}
	
	public List<Smoothie> getSmoothieByName(String name){
		return sr.findSmoothiesByNameIgnoreCase(name);
	}
}
