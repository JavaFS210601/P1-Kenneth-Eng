/**
 * 
 */
package com.revature.daos;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.Food;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;


/**
 * @author Kenneth Eng
 *
 */
public class UserDao {
	
	
	public User findUserByUsernameAndPassword(String username, String password) {
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		//User user = ses.load(User.class, id);
		//User user = (User)ses.createQuery("FROM User as user WHERE user.username = :username"  
				//+ " AND user.password = :password");
		String hql = "FROM User as user WHERE user.username = :username"  
				+ " AND user.password = :password";
		Query query = ses.createQuery(hql);
		query.setParameter("username",username);
		query.setParameter("password", password);
		User user = (User)query.getSingleResult();
		
		
		HibernateUtil.closeSession();
		
		return user;
	}
	
	public void insertUser(User user) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(user);
		
		HibernateUtil.closeSession();
	}


	public void updateUser(User user) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.merge(user); 
		//this will update the entire food record in the database
		// merge over update because merge is safer
	}
	
	public User selectUserById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		//User user = ses.load(User.class, id);
		User user = (User)ses.createQuery("FROM User as user WHERE user.id = " + id).getSingleResult();
		
		
		HibernateUtil.closeSession();
		
		return user;
		
	}
	
	public User getUserById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		User user = ses.get(User.class, id);
		
		HibernateUtil.closeSession();
		
		return user;
		
	}
	
	public List<User> findAllUsers(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language that references the java class
		// e.g. "Food" in our model package, instead of "Food" in database.
		
		List<User> userList = ses.createQuery("FROM User").list();
		// at the end, we are turing the results into a list
		
		HibernateUtil.closeSession();
		
		return userList;
		
	}
	
//	
//	public UserRole getUserRoleByName(int id) {
//		Session ses = HibernateUtil.getSession();
//		
//		UserRole userRole = ses.get(UserRole.class, id);
//		
//		HibernateUtil.closeSession();
//		
//		return userRole;
//	}


	public List<UserRole> getAllUserRole() {
		Session ses = HibernateUtil.getSession();
		
		
		List<UserRole> userRoleList = ses.createQuery("FROM UserRole").list();
		
		HibernateUtil.closeSession();
		
		return userRoleList ;
		
		
	}
}
