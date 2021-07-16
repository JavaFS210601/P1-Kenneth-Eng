/**
 * 
 */
package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Kenneth Eng
 *
 */
@Entity
@Table(name = "food_types") 
public class FoodTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_type_id" )
	private int foodTypeId;
	
	@Column(name = "food_type")
	private String foodType;
	
	@OneToMany(mappedBy="foodtype", fetch=FetchType.EAGER)
	private List<Food> typeList = new ArrayList<>();

	
	
	public FoodTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FoodTypes(int foodTypeId, String foodType) {
		super();
		this.foodTypeId = foodTypeId;
		this.foodType = foodType;
	}




	public FoodTypes(String foodType) {
		super();
		this.foodType = foodType;
	}

	

	public String getFoodType() {
		return foodType;
	}



	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	

	public int getFoodTypeId() {
		return foodTypeId;
	}



	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}



	@Override
	public String toString() {
		return "FoodTypes [foodTypeId=" + foodTypeId + ", foodType=" + foodType  + "]";
	}
	
	
	
	
}
