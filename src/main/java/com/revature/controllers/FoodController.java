/**
 * 
 */
package com.revature.controllers;

import java.util.List;

import com.revature.daos.FoodDao;
import com.revature.models.Food;
import com.revature.models.Manager;

/**
 * @author Kenneth Eng
 *
 */
public class FoodController {
	
	private FoodDao foodDao = new FoodDao();
	
	public void loadAllFood() {
		Manager m1 = new Manager( "firstname",  "last_name");
		
		Food f1 = new Food("bread1", 1, 1 ,m1); // bean type id is 1
		Food f2 = new Food("bean1", 1, 1 , m1);  // status of good is 1
		
		// insert new food using our FoodDAO method
		foodDao.insertFood(f1);
		foodDao.insertFood(f2);
		
		// Find all foods
		List<Food> foods = foodDao.findAllFoods();
		
		for(Food f : foods) {
			System.out.println(f.getId() + " " + f.getName() + " " + f.getTypeId() + f.getStatusId());
			
		}
		
		
	}
}
