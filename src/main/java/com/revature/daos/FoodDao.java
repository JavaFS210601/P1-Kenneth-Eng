/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Food;
import com.revature.utils.HibernateUtil;

/**
 * @author Kenneth Eng
 *
 */
public class FoodDao {
	
	public void insertFood(Food food) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(food);
		
		HibernateUtil.closeSession();
	}
	
	public void updateFood(Food food) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.merge(food); 
		//this will update the entire food record in the database
		// merge over update because merge is safer
	}
	
	public Food SelectFoodById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		Food food = ses.get(Food.class, id);
		
		HibernateUtil.closeSession();
		
		return food;
		
	}
	
	public List<Food> findAllFoods(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language that references the java class
		// e.g. "Food" in our model package, instead of "Food" in database.
		
		List<Food> foodList = ses.createQuery("FROM Food").list();
		// at the end, we are turing the results into a list
		
		HibernateUtil.closeSession();
		
		return foodList;
		
	}
	
	
}
