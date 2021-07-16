/**
 * 
 */
package com.revature.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.CustomerDao;
import com.revature.daos.CustomerDaoInterface;
import com.revature.daos.FoodDao;
import com.revature.models.Customer;
import com.revature.models.Food;
import com.revature.models.FoodStatus;
import com.revature.models.FoodTypes;

/**
 * Service Layer sit between controller and dao layer 
 * so the web access layer never need to touch the
 * database access layer.
 * @author Kenneth Eng
 *
 */
public class FoodService {
	
	private FoodDao foodDao = new FoodDao();
	
	public boolean  insertFood(Food food) {
		foodDao.insertFood(food);
		return true;
	}
	
	public List<Food> getAllFood() {
		return foodDao.findAllFoods();
	}
//	public String getAllFoodAsJson() throws IOException {
//		return foodDao.findAllFoodsAsJson();
//	}
	
	public FoodStatus getFoodStatuById(int id) {
		return foodDao.getFoodStatuById(id);
	}
	
	public List<Food> getFoodsByType(int type){
		return foodDao.selectFoodByType(type);
	}
	
	public FoodTypes getFoodTypeById(int id) {
		return foodDao.getFoodTypeById(id);
	}
	
	public List<Food> getFoodsByUserId(int userid){
		List<Food> foods= foodDao.findAllFoods();
		List<Food> usersFoods = new ArrayList<>();
		for (Food food : foods) {
			if (food.getOwner().getUserId() == userid) {
				usersFoods.add(food);
			}
		}
		
		return usersFoods;
	}
	
	public List<FoodTypes> getAllFoodTypes(){
		return foodDao.getFoodtypes();
	}
}
