package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Ingredient;

@Service
public class FruitService {

	public List<Ingredient> getFruitByName(String name) {
		String url = "https://www.fruityvice.com/api/fruit/";
		RestTemplate rt = new RestTemplate();
		List<Ingredient> ingredients = new ArrayList<>();
		Ingredient f = rt.getForObject(url + name, Ingredient.class);
		ingredients.add(f);
		return ingredients;
	}
	
	public List<Ingredient> getAllFruits() {
		ResponseEntity<List<Ingredient>> responseEntity;
		String url = "https://www.fruityvice.com/api/fruit/all";
		RestTemplate rt = new RestTemplate();
		responseEntity = rt.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<Ingredient>>() {});
		List<Ingredient> ingredients = responseEntity.getBody();
		return ingredients;
	}

}
