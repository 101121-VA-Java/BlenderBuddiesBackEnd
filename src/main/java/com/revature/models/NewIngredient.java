package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="new_ingredient")
public class NewIngredient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nGredId;
	@Length(min=3)
	@Column(nullable=false)
	private String name;
	@OneToOne
	private Nutrition nutritions;

	public NewIngredient() {
		super();
	}

	public int getnGredId() {
		return nGredId;
	}

	public void setnGredId(int nGredId) {
		this.nGredId = nGredId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nutrition getNutrions() {
		return nutritions;
	}

	public void setNutrions(Nutrition nutrions) {
		this.nutritions = nutrions;
	}

	@Override
	public String toString() {
		return "NewIngredient [nGredId=" + nGredId + ", name=" + name + ", nutrions=" + nutritions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nGredId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nutritions == null) ? 0 : nutritions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewIngredient other = (NewIngredient) obj;
		if (nGredId != other.nGredId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nutritions == null) {
			if (other.nutritions != null)
				return false;
		} else if (!nutritions.equals(other.nutritions))
			return false;
		return true;
	}

	
}