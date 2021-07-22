/**
 * 
 */
package com.revature.daos;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.models.deprecated.Food;
import com.revature.utils.HibernateUtil;


/**
 * The DAO object that are responsible for communicate with database using 
 * Hibernate to handle user data
 * 
 * @author Kenneth Eng
 *
 */
public class UserDao {
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return user that is found
	 * 
	 * param username - the username of the user
	 * param password - the password of the user
	 */
	public User findUserByUsernameAndPassword(String username, String password) {
		Session ses = HibernateUtil.getSession();
		
	
		String hql = "FROM User as user WHERE user.username = :username"  
				+ " AND user.password = :password";
		Query query = ses.createQuery(hql);
		query.setParameter("username",username);
		query.setParameter("password", password);
		User user = (User)query.getSingleResult();
		
		
		HibernateUtil.closeSession();
		
		return user;
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * insert the  user
	 * 
	 * param user - User object that is to be inserted	
	 * 
	 */
	public void insertUser(User user) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(user);
		
		HibernateUtil.closeSession();
	}

	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * update the user
	 * 
	 * param user - User object that is to be inserted
	 * 
	 */
	public void updateUser(User user) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.merge(user); 
		//this will update the entire food record in the database
		// merge over update because merge is safer
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * retrieve the user by id
	 * 
	 * param id - the user id 
	 * 
	 */
	public User selectUserById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		//User user = ses.load(User.class, id);
		User user = (User)ses.createQuery("FROM User as user WHERE user.id = " + id).getSingleResult();
		
		
		HibernateUtil.closeSession();
		
		return user;
		
	}
	
	// deprecated
	public User getUserById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		User user = ses.get(User.class, id);
		
		HibernateUtil.closeSession();
		
		return user;
		
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * retrieve all the users in the database
	 * 
	 */
	public List<User> findAllUsers(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language that references the java class
		// e.g. "Food" in our model package, instead of "Food" in database.
		
		List<User> userList = ses.createQuery("FROM User").list();
		// at the end, we are turing the results into a list
		
		HibernateUtil.closeSession();
		
		return userList;
		
	}
	


	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * retrieve all the user roles in the database 
	 * 
	 */
	public List<UserRole> getAllUserRole() {
		Session ses = HibernateUtil.getSession();
		
		
		List<UserRole> userRoleList = ses.createQuery("FROM UserRole").list();
		
		HibernateUtil.closeSession();
		
		return userRoleList ;
		
		
	}
}
