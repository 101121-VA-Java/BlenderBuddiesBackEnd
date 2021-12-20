package com.revature.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name="ingredients")
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Length(min=3)
	@Column(nullable=false, unique=true)
	private String name;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Nutrition nutritions;
	
//	@JsonBackReference
	@ManyToMany(mappedBy = "recipe")
	Set<Smoothie> ingredient;
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(int id) {
		super();
		this.id = id;
	}

	
	
	
}