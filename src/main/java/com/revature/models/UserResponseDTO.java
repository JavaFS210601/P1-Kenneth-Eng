/**
 * 
 */
package com.revature.models;

/**
 * @author Kenneth Eng
 *
 */
public class UserResponseDTO {
	
	int userid;
	String username;
	String password;
	String firstname;
	String lastname;
	String userrole;
	
	
	public UserResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDTO(int userid, String username, String password, String firstname, String lastname,
			String userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.userrole = userrole;
	}
	@Override
	public String toString() {
		return "UserResponseDTO [userid=" + userid + ", username=" + username + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", userrole=" + userrole + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	
	
}
