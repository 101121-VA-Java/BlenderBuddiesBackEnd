package com.revature.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.models.Nutrition;

import lombok.Data;

@Data

public class SimpleIngredient {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("nutritions")
	private Nutrition nutritions;
}
