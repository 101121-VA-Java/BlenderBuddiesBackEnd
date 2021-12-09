package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="nutritions")
public class Nutrition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nutId;
	@Column(nullable=false)
	@JsonProperty("carbohydrates")
	private double carb;
	@Column(nullable=false)
	@JsonProperty("protein")
	private double prot;
	@Column(nullable=false)
	@JsonProperty("fat")
	private double phat;
	@Column(nullable=false)
	@JsonProperty("calories")
	private int calo;
	@Column(nullable=false)
	@JsonProperty("sugar")
	private double suga;

	public Nutrition() {
		super();
	}

	public Nutrition(int nutId, double carb, double prot, double phat, int calo, double suga) {
		super();
		this.nutId = nutId;
		this.carb = carb;
		this.prot = prot;
		this.phat = phat;
		this.calo = calo;
		this.suga = suga;
	}

	public int getNutId() {
		return nutId;
	}

	public void setNutId(int nutId) {
		this.nutId = nutId;
	}

	public double getCarb() {
		return carb;
	}

	public void setCarb(double carb) {
		this.carb = carb;
	}

	public double getProt() {
		return prot;
	}

	public void setProt(double prot) {
		this.prot = prot;
	}

	public double getPhat() {
		return phat;
	}

	public void setPhat(double phat) {
		this.phat = phat;
	}

	public int getCalo() {
		return calo;
	}

	public void setCalo(int calo) {
		this.calo = calo;
	}

	public double getSuga() {
		return suga;
	}

	public void setSuga(double suga) {
		this.suga = suga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calo;
		long temp;
		temp = Double.doubleToLongBits(carb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nutId;
		temp = Double.doubleToLongBits(phat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prot);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(suga);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Nutrition other = (Nutrition) obj;
		if (calo != other.calo)
			return false;
		if (Double.doubleToLongBits(carb) != Double.doubleToLongBits(other.carb))
			return false;
		if (nutId != other.nutId)
			return false;
		if (Double.doubleToLongBits(phat) != Double.doubleToLongBits(other.phat))
			return false;
		if (Double.doubleToLongBits(prot) != Double.doubleToLongBits(other.prot))
			return false;
		if (Double.doubleToLongBits(suga) != Double.doubleToLongBits(other.suga))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nutrition [nutId=" + nutId + ", carb=" + carb + ", prot=" + prot + ", phat=" + phat + ", calo=" + calo
				+ ", suga=" + suga + "]";
	}

	

}