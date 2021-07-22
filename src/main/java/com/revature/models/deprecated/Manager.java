/**
 * 
 */
package com.revature.models.deprecated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
@Table(name = "manager")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private int id;
	
	@Column(name = "fist_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String last_name;

	/* 
	 * One to Many relationship by doing the following.
	 * toString of this class might break the problem with stackoverthrown 
	 * Fix: change the toString() of Food to use get Methods of Manager class.
	*/
	@OneToMany(mappedBy="manager", fetch=FetchType.EAGER)
	private List<Food> anthology = new ArrayList<>();

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Manager(int id, String firstname, String last_name) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.last_name = last_name;
	}

	public Manager(String firstname, String last_name) {
		super();
		this.firstname = firstname;
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", last_name=" + last_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, id, last_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(last_name, other.last_name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	
}
