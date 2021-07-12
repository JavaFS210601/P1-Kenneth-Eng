/**
 * 
 */
package com.revature.models;

/**
 * Data Access Object for temporary json data from client.
 * 
 * @author Kenneth Eng
 *
 */
public class LoginDTO {

		public String username;
		public String password;
		
		public LoginDTO() {
			super();
		}

		public LoginDTO(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		

	
}
