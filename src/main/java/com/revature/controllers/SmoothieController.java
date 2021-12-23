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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Smoothie;
import com.revature.services.SmoothieService;

@RestController
@RequestMapping("/smoothies")
@CrossOrigin("*")
public class SmoothieController {

	private SmoothieService ss;
	
	@Autowired
	public SmoothieController(SmoothieService ss) {
		this.ss = ss;
	}
	
	@GetMapping
	public List<Smoothie> getAllSmoothies(@RequestParam(name="name", required = false)String name, @RequestParam(name="id", required = false)Integer id){
		if(name != null) {
			return ss.getSmoothieByName(name);
		}
		if(id != null) {
			return ss.getSmoothieByTypeAndUser(id);
		}
		return ss.getAllSmoothies();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Smoothie> getSmoothieById(@PathVariable("id")int id){
		return new ResponseEntity<>(ss.getSmoothieById(id), HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<String> createSmoothie(@Valid @RequestBody Smoothie smoothie){
		ss.createSmoothie(smoothie);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
