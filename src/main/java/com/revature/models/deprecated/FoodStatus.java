/**
 * 
 */
package com.revature.models.deprecated;

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
@Table(name = "food_status") 
public class FoodStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_status_id" )
	private int foodStatusId;
	
	@Column(name = "food_status")
	private String foodStatus;
	
	@OneToMany(mappedBy="foodstatus", fetch=FetchType.EAGER)
	private List<Food> statusList = new ArrayList<>();

	
	public FoodStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FoodStatus(int foodStatusId, String foodStatus) {
		super();
		this.foodStatusId = foodStatusId;
		this.foodStatus = foodStatus;
	}



	public FoodStatus(String foodStatus) {
		super();
		this.foodStatus = foodStatus;
	}

	

	public int getFoodStatusId() {
		return foodStatusId;
	}


	public void setFoodStatusId(int foodStatusId) {
		this.foodStatusId = foodStatusId;
	}


	public String getFoodStatus() {
		return foodStatus;
	}


	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}


	@Override
	public String toString() {
		return "FoodStatus [foodStatusId=" + foodStatusId + ", foodStatus=" + foodStatus 
				+ "]";
	}
	
	
	
}
