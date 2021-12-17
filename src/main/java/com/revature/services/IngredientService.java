package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.IngredientRepository;
import com.revature.models.Ingredient;



@Service
public class IngredientService {
	private IngredientRepository ir;
	
	@Autowired
	public IngredientService(IngredientRepository ir) {
		this.ir = ir;
	}
	
	public List<Ingredient> getAllIngredients(){
		return ir.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void createIngredient(Ingredient i) {
		ir.save(i);
	}
	
	public List<Ingredient> getIngredientByName(String name){
		return ir.findIngredientByNameIgnoreCase(name);
	}
	
	//Adjust Quantity

}
