/**
 * 
 */
package com.revature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.daos.UserDao;
import com.revature.daos.deprecated.FoodDao;
import com.revature.models.deprecated.Food;

/**
 * @author Kenneth Eng
 *
 */
public class DaoTest {
	
	private FoodDao foodDao;
	private UserDao userDao;
	
	int type  = 1;
	int status = 1;
	Food food;
	
	public int foodid;
	public String foodtype;
	public String foodstatus;
	public String foodname;
	
	public int userid;
	public String username;
	
	
	

	@BeforeAll 
	public static void init() {
		System.out.println("In BeforeAll");
		
		//DaoTest dt = new DaoTest();
	}
	
	@BeforeEach
	public void setBaseValues() {
		foodDao = new FoodDao();
		
		userDao = new UserDao();
		
		System.out.println("In BeforeEach");
		
		//food with id 2 in the cache table
		foodid= 8;
		foodtype = "fruits";
		foodstatus = "good";
		foodname = "fruit1";
		
		// user with id 1
		username = "ocean";
		userid = 2;
//		food.setFoodstatus(1);
//		food.setFoodtype(1);
//		food.setName("bread1");
	}
	
	@AfterEach
	public void clear() {
		System.out.println("In AfterEach");
		//reset values here
	}
	
	/*
	 * Test if the user dao object return the correct value
	 * 
	 * First the id of object is matched to the pre-define values
	 * and then do the rest of matching with other columns.
	 */
	@Test
	public void testUserDao() {
		//assertNotEquals)()
		//assertEquals(userid, userDao.findAllUsers().get(0).getUserId());
		
		
		//test get method of session object and method that run HQL   
		
		 // here I have to put the array index for get method to work
		assertEquals(userid, userDao.selectUserById(userid).getUserId());
		
		assertEquals(username, userDao.selectUserById(userid).getUsername());
		
		assertEquals(userid, userDao.getUserById(userid).getUserId());
		
		assertEquals(username, userDao.getUserById(userid).getUsername());
		
	
		
	}
	
	/*
	 * Test if the food dao object return the correct value with the food id
	 */
	@Test
	public void testFoodDao() {
		
		// test HQL method for food
		
		Food food = foodDao.SelectFoodById(foodid);
		
		assertEquals(foodid, food.getId());
		
		int statusid =foodDao.SelectFoodById(foodid).getFoodstatus().getFoodStatusId();
		
		assertEquals(foodstatus, food.getFoodstatus().getFoodStatus()); //foodDao.getFoodStatuById(statusid).getFoodStatus()
		
		assertEquals(foodname, food.getName());
		
		assertEquals(foodtype, food.getFoodtype().getFoodType());
		
	}
	

}
