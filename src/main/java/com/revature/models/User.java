/**
 * 
 */
package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User class that represent each registered user.
 * 
 * @author Kenneth Eng
 *
 */

@Entity
@Table(name = "ers_users") 
public class User {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id") 
	private int userId;
	
	@Column(name = "user_name") 
	private String username;
	
	@Column(name = "user_password") 
	private String password;
	
	@Column(name = "user_firstname") 
	private String firstname;
	
	@Column(name = "user_lastname") 
	private String lastname;
	
	@Column(name = "user_email") 
	private String email;
	
	@Column(name = "user_role_id") 
	private int roleId;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String firstname, String lastname, String email, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleId = roleId;
	}

	public User(int userId, String username, String password, String firstname, String lastname, String email,
			int roleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", roleId=" + roleId + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, lastname, password, roleId, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password)
				&& roleId == other.roleId && userId == other.userId && Objects.equals(username, other.username);
	}
	
	
	
	
}
