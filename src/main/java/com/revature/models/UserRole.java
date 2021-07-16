/**
 * 
 */
package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Kenneth Eng
 *
 */
@Entity
@Table(name = "user_roles") 
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id" )
	private int userId;
	
	@Column(name = "user_role")
	private String userRole;
	
	@OneToMany(mappedBy="userrole", fetch=FetchType.EAGER)
	private List<User> roleList = new ArrayList<>();

	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UserRole(int userId, String userRole) {
		super();
		this.userId = userId;
		this.userRole = userRole;
	}



	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}


	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", userRole=" + userRole +  "]";
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public List<User> getRoleList() {
		return roleList;
	}


	public void setRoleList(List<User> roleList) {
		this.roleList = roleList;
	}
	
	
	
	
	
}
