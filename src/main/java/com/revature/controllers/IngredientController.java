package com.revature.controllers;

import java.util.ArrayList;
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

import com.revature.models.Ingredient;
import com.revature.services.FruitService;
import com.revature.services.IngredientService;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin("*")
public class IngredientController {
	private IngredientService is;
	private FruitService fs;
	
	@Autowired
	public IngredientController(IngredientService is, FruitService fs) {
		this.is = is;
		this.fs = fs;
	}
	
	@GetMapping
	public List<Ingredient> getAllIngredients(@RequestParam(name="name", required = false)String name){
		if(name != null) {
			List<Ingredient> test = null;
			test = is.getIngredientByName(name);
			if (test.isEmpty()) {
				test = fs.getFruitByName(name);
				//createIngredient(test.get(0));
			}
			return test;
		}
		List<Ingredient> one = is.getAllIngredients();
		List<Ingredient> two = fs.getAllFruits();
		List<Ingredient> three = new ArrayList<>();
		three.addAll(one);
		three.addAll(two);
		
		return three;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id")int id){
		return new ResponseEntity<>(is.getIngredientById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createIngredient(@Valid @RequestBody Ingredient ingredient){
		is.createIngredient(ingredient);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}

