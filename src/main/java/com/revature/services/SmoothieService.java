package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.SmoothieRepository;
import com.revature.daos.UserRepository;
import com.revature.exceptions.SmoothieNotFoundException;
import com.revature.models.RoleEnum;
import com.revature.models.Smoothie;
import com.revature.models.User;

@Service
public class SmoothieService {
	private SmoothieRepository sr;
	private UserRepository ur;
	
	@Autowired
	public SmoothieService(SmoothieRepository sr, UserRepository ur) {
		this.sr = sr;
		this.ur = ur;
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
	
	public List<Smoothie> getSmoothieByTypeAndUser(int id){
		User u = ur.getById(id);
		List<Smoothie> temp1 = sr.findSmoothiesByType(RoleEnum.ADMIN);
		List<Smoothie> temp2 = sr.findSmoothiesByUser(u);
		List<Smoothie> total = new ArrayList<>();
		total.addAll(temp1);
		total.addAll(temp2);
		
		return total;	
	}
	
	public List<Smoothie> getSmoothieByName(String name){
		return sr.findSmoothiesByNameIgnoreCase(name);
	}
}
