/**
 * 
 */
package com.revature.models;

import javax.persistence.Column;

/**
 * Data Access Object for temporary json data from client.
 * 
 * @author Kenneth Eng
 *
 */
public class RegisterDTO {

		public String username;
		public String password;
		private String firstname;
		
		private String lastname;
		
		private String email;
		
		private String role;
		
		public RegisterDTO() {
			super();
		}

		public RegisterDTO(String username, String password, String firstname, String lastname, String email,
				String role) {
			super();
			this.username = username;
			this.password = password;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.role = role;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		
		

	
}
