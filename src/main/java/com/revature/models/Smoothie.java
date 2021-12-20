package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name="smoothies")
public class Smoothie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int smoothId;
	@Column(nullable=false)
	private String name;
	private String descrip;
	private String url;
	@Enumerated(EnumType.STRING)
	private RoleEnum type;
	@OneToOne
	private User user;
	@ManyToMany
	@JsonIgnoreProperties("ingredient")
	@JoinTable(
			name = "recipes",
			joinColumns = @JoinColumn(name = "smoothie_id"),
			inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	List<Ingredient> recipe;
			
}