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
public class RegisterDTO {

		public String username;
		public String password;
		
		public RegisterDTO() {
			super();
		}

		public RegisterDTO(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		

	
}
