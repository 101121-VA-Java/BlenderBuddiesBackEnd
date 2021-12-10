package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Need to work on this ManyToMany???
//@Component
@Entity
@Table(name="recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int repId;
	private int nGredId;
	private int fruitId;
	@Column(nullable=false)
	private int smoothId;

	public Recipe() {
		super();
	}

	public int getRepId() {
		return repId;
	}

	public void setRepId(int repId) {
		this.repId = repId;
	}

	public int getnGredId() {
		return nGredId;
	}

	public void setnGredId(int nGredId) {
		this.nGredId = nGredId;
	}

	public int getFruitId() {
		return fruitId;
	}

	public void setFruitId(int fruitId) {
		this.fruitId = fruitId;
	}

	public int getSmoothId() {
		return smoothId;
	}

	public void setSmoothId(int smoothId) {
		this.smoothId = smoothId;
	}

	@Override
	public String toString() {
		return "Recipe [repId=" + repId + ", nGredId=" + nGredId + ", fruitId=" + fruitId + ", smoothId=" + smoothId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fruitId;
		result = prime * result + nGredId;
		result = prime * result + repId;
		result = prime * result + smoothId;
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
		Recipe other = (Recipe) obj;
		if (fruitId != other.fruitId)
			return false;
		if (nGredId != other.nGredId)
			return false;
		if (repId != other.repId)
			return false;
		if (smoothId != other.smoothId)
			return false;
		return true;
	}

}