package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="smoothies")
public class Smoothie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int smoothId;
	private String decrip;
	private String url;
	@Column(nullable=false)
	private String name;
	@Enumerated(EnumType.STRING)
	private RoleEnum type;
	@OneToOne
	private User user;
	@ManyToMany
	@JoinTable(
			name = "ingredients_used",
			joinColumns = @JoinColumn(name = "smoothie_id"),
			inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	Set<Ingredient> recipe;
			
}