/**
 * 
 */
package com.revature.services;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.revature.daos.FoodDao;
import com.revature.daos.ManagerDao;
import com.revature.daos.UserDao;
import com.revature.models.Manager;
import com.revature.models.User;
import com.revature.models.UserRole;



/**
 * @author Kenneth Eng
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	private ManagerDao mdao = new ManagerDao();
	
	public User getUserByUserByUsernameAndPassword(String username, String password) {
			User user = userDao.findUserByUsernameAndPassword(username, password);
		
			return user;
	}

	public boolean login(String username, String password) {
		User user = userDao.findUserByUsernameAndPassword(username, password);

		// Validation below
		
		if (user != null) {
			return true;
		}
		return false;
	}

	public boolean register(String username, String password , String email , String role) {
		List<UserRole> userRoles = userDao.getAllUserRole();
		
        User user = null;
        try {
        	user = userDao.findUserByUsernameAndPassword(username, password);
        } catch( Exception e) {
        
        }
        
		if ( user != null) {
			// already have an account
			return false;
		} else {
			for(UserRole sr : userRoles) {
				if ( sr.getUserRole().equals(role)) {
					System.out.println(username + "registered " + sr.getUserId());
					userDao.insertUser(new User(username, password, sr));
				}
			}
			
		}

		return true;
	}

	public boolean findUserByName(String name) {
		List<User> userList = userDao.findAllUsers();
		
		for (User user : userList) {
			
			if (user.getUsername().matches( name)) {
				return true;
			}
		}
		return false;
	}

	public List<User> getAllUsers() {
		return userDao.findAllUsers();
	}

	public User getUserById(int id) {
		return userDao.selectUserById(id);
	}
	
	/*
	 * Deprecated
	 */
	public Manager getManagerById(int id) {
		return mdao.getManagerById(id);
	}
//	public UserRole getUserRoleById(int id) {
//		return userDao.getUserRoleByName(id);
//	}





}
