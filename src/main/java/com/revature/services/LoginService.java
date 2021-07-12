/**
 * 
 */
package com.revature.services;

/**
 * @author Kenneth Eng
 *
 */
public class LoginService {

	public boolean login(String username, String password) {
		
		// Validation below
		if (username.equals("ken") && password.equals("eng")) {
			return true;
		}
		return false;
	}

}
