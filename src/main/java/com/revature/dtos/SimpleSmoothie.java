package com.revature.dtos;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SimpleSmoothie {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("descrip")
	private String descrip;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("recipe")
	private Set<SimpleIngredient> recipe;
}
