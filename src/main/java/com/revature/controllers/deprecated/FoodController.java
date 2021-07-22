/**
 * 
 */
package com.revature.controllers.deprecated;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.deprecated.FoodDao;
import com.revature.daos.deprecated.ManagerDao;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.models.deprecated.Food;
import com.revature.models.deprecated.FoodStatus;
import com.revature.models.deprecated.FoodTypes;
import com.revature.models.deprecated.FoodsResponseDTO;
import com.revature.models.deprecated.Manager;
import com.revature.services.UserService;
import com.revature.services.deprecated.FoodService;

/**
 * @author Kenneth Eng
 *
 */
public class FoodController {
	
	//private FoodDao foodDao = new FoodDao();
	private FoodService foodService = new FoodService();
	private ObjectMapper  om = new ObjectMapper();
	private UserService userService = new UserService();
	
	
	private List<FoodTypes> foodTypesList;
	
	

	public FoodController() {
		super();
		
		foodTypesList = foodService.getAllFoodTypes();
	}


	public void initDB() throws IOException {
	
		
		Manager m1 = new Manager( 0, "ken",  "eng");
		UserRole r1 = new UserRole(0, "manager");
		// name, firstname, password, lastname, user emial, role id
		User u1 = new User("kenng"  , "pwd", "ken","eng" ,"a@a.com", r1);
		
		FoodTypes t1 =    new FoodTypes(0,"bread");
		FoodStatus s1 = new FoodStatus(0, "good");
		// name, owner id , type id , status id, 
		Food f1 = new Food("bread1", u1, t1 , s1 ,m1); // bean type id is 1 and owner id is 1
		foodService.insertFood(f1);
		
	}
	
	
	public void insertFood(HttpServletResponse res) throws IOException {
		
		Manager m1 = userService.getManagerById(1);
		//UserRole r1 = userService.getUserRoleById(1);
		// name, firstname, password, lastname, user emial, role id
		//User u1 = new User(1 ,"kenng"  , "pwd", "ken","eng" ,"a@a.com", r1);
		User u1 = userService.getUserById(1);
		UserRole r1= u1.getUserrole();
		FoodTypes t1 = foodService.getFoodTypeById(1);
		FoodStatus s1 = foodService.getFoodStatuById(1);
		// name, owner id , type id , status id, 
		Food f1 = new Food("bread1", u1, t1 , s1 ,m1); // bean type id is 1 and owner id is 1
		foodService.insertFood(f1);
		
	}
	
	public void getAllFoodTypes(HttpServletResponse res) throws IOException {
		String json = om.writeValueAsString(foodTypesList); 
		
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
	public void getFoodByType(HttpServletResponse res, String type) throws IOException {
		String type1 = type.toLowerCase();
		int id = 0;
		for (FoodTypes t: foodTypesList ) {
			
			if (type1.equals(t.getFoodType())) {
				id = t.getFoodTypeId();
				break;
			}
			
		}
		
		List<Food> foods = foodService.getFoodsByType(id);
		
		List<FoodsResponseDTO> foodResponseList = new ArrayList<FoodsResponseDTO>();
		for(Food f : foods) {
			//System.out.println(f.getId() + " " + f.getName() + " " + f.getFoodtype().toString() + f.getFoodstatus().toString());
			FoodsResponseDTO foodResponse = new FoodsResponseDTO();
			foodResponse.setFoodid(f.getId());
			foodResponse.setFoodname(f.getName());
			foodResponse.setFoodtype(f.getFoodtype().getFoodType());
			foodResponse.setFoodstatus(f.getFoodstatus().getFoodStatus());
			foodResponseList.add(foodResponse);
		}
		
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String json = om.writeValueAsString(foodResponseList);
		System.out.println(json);
		res.getWriter().print(json);
		
		res.setStatus(200);
	}
	
	public void getFoodByUserId(HttpServletResponse res) throws IOException{
		int userid = 1;
		List<Food> foods = foodService.getFoodsByUserId(userid);
		
		List<FoodsResponseDTO> foodResponseList = new ArrayList();
		for(Food f : foods) {
			System.out.println(f.getId() + " " + f.getName() + " " + f.getFoodtype().toString() + f.getFoodstatus().toString());
			FoodsResponseDTO foodResponse = new FoodsResponseDTO();
			foodResponse.setFoodid(f.getId());
			foodResponse.setFoodname(f.getName());
			foodResponse.setFoodtype(f.getFoodtype().getFoodType());
			foodResponse.setFoodstatus(f.getFoodstatus().getFoodStatus());
			foodResponseList.add(foodResponse);
		}
		
		// Construct the response here
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String json = om.writeValueAsString(foodResponseList);
		res.getWriter().print(json);
		
		res.setStatus(200);
		
	}
	
	public void loadAllFood(HttpServletResponse res) throws IOException{
		System.out.println("Hello from Food Controller");
		
		//initDB();
		//insertFood(res); 
		List<Food> foods = foodService.getAllFood();
		
		
		List<FoodsResponseDTO> foodResponseList = new ArrayList();
		for(Food f : foods) {
			System.out.println(f.getId() + " " + f.getName() + " " + f.getFoodtype().toString() + f.getFoodstatus().toString());
			FoodsResponseDTO foodResponse = new FoodsResponseDTO();
			foodResponse.setFoodid(f.getId());
			foodResponse.setFoodname(f.getName());
			foodResponse.setFoodtype(f.getFoodtype().getFoodType());
			foodResponse.setFoodstatus(f.getFoodstatus().getFoodStatus());
			foodResponseList.add(foodResponse);
		}
		
		// Construct the response here
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String json = om.writeValueAsString(foodResponseList);
		res.getWriter().print(json);
		
		res.setStatus(200);
		
		
	}
}
