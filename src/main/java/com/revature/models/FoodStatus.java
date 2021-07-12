/**
 * 
 */
package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kenneth Eng
 *
 */
@Entity
@Table(name = "ers_food_status") 
public class FoodStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_status_id" )
	int foodStatusId;
	
	@Column(name = "food_status")
	String foodStatus;
}
