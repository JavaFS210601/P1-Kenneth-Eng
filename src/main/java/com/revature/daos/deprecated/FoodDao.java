/**
 * 
 */
package com.revature.daos.deprecated;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.deprecated.Food;
import com.revature.models.deprecated.FoodStatus;
import com.revature.models.deprecated.FoodTypes;
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
	
	public List<Food> selectFoodByType(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM Food WHERE food_type_id = " + id;
//		@SuppressWarnings({ "deprecation", "unchecked" })
//		Query<Food> query = ses.createQuery(hql);
		

		List<Food> results = ses.createQuery(hql).list();
		return results;
	}
	
	public Food SelectFoodById(int id) {
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		Food food = (Food)ses.createQuery("FROM Food as food WHERE food.id = " + id).getSingleResult();
		
		//System.out.println(food);
		
		
		HibernateUtil.closeSession();
		
		return food;
	}
	
	public Food getFoodById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		Food food = ses.get(Food.class, id);
		
		HibernateUtil.closeSession();
		
		return food;
		
	}
	
	public FoodStatus getFoodStatuById(int id) {
		Session ses  = HibernateUtil.getSession();
		
		FoodStatus foodStatu= ses.get(FoodStatus.class, id);
		
		HibernateUtil.closeSession();
		
		return  foodStatu;
	}
	
	public FoodTypes getFoodTypeById(int id) {
		Session ses  = HibernateUtil.getSession();
		
		FoodTypes foodType= ses.get(FoodTypes.class, id);
		
		HibernateUtil.closeSession();
		
		return  foodType;
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
	public List<FoodTypes> getFoodtypes() {
		
		Session ses = HibernateUtil.getSession();
		
		List<FoodTypes> foodTypes = ses.createQuery("FROM FoodTypes").list();
		
		HibernateUtil.closeSession();
		
		return foodTypes;
	}
	
//	public String findAllFoodsAsJson() throws IOException{
//		
//		Session ses = HibernateUtil.getSession();
//		ObjectMapper  om = new ObjectMapper();
//		//Using HQL! Hibernate Query Language that references the java class
//		// e.g. "Food" in our model package, instead of "Food" in database.
//		
//		List<Food> foodList = ses.createQuery("FROM Food").list();
//		// at the end, we are turing the results into a list
//		String json = om.writeValueAsString(foodList);
//		
//		HibernateUtil.closeSession();
//		
//		return json;
//		
//	}
	

	
}
