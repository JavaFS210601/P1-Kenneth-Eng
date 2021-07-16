package com.revature.models;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "foods") // this isn't necessary , but it specifics the name of table as "foods"
public class Food {
	
	@Id  // it makes it a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id") // it specific the name of the id field
	private int id;
	
	@Column(name = "food_name", nullable = false)
	private String name;
	
	@Column(name = "food_receipt")
	private String receipt;
	
	@ManyToOne(targetEntity=User.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User owner;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "food_type_id", nullable = false )
	private FoodTypes foodtype;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "food_status_id", nullable = false )
	private FoodStatus foodstatus;
	
	/*
	 * FetchType defines "When" hibernate will go to the database
	 * to fetch an associated object
	 * Types: 
	 * "LAZY" -  Hibernate will give a proxy object instead of going to 
	 * the database, until your code actually calls for the object. This only 
	 * works while the object is in the database 
	 * Once it leaves the database, there are no longer a Session to 
	 * replace the proxy. 
	 * 
	 * "EAGER" - Returns the dependent object immediately without making 
	 * a proxy object. This is generally less error prone because proxy 
	 * no longer be avilable if sessions is closed.
	 * 
	 * Here Manager can be null.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
 	private Manager manager;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String name, User owner, FoodTypes type, FoodStatus foodstatus, Manager manager) {
		super();
		this.name = name;
		this.owner = owner;
		this.foodtype = type;
		this.foodstatus = foodstatus;
		this.manager = manager;
	}

	public Food(int id, String name,  User owner, FoodTypes type, FoodStatus foodstatus, Manager manager) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.foodtype = type;
		this.foodstatus = foodstatus;
		this.manager = manager;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
	public FoodTypes getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(FoodTypes foodtype) {
		this.foodtype = foodtype;
	}

	public FoodStatus getFoodstatus() {
		return foodstatus;
	}

	public void setFoodstatus(FoodStatus foodstatus) {
		this.foodstatus = foodstatus;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", receipt=" + receipt + ", owner=" + owner + ", foodtype=" + foodtype
				+ ", foodstatus=" + foodstatus + ", manager=" + manager + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, manager, name, owner, receipt, foodstatus, foodtype);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return id == other.id && Objects.equals(manager, other.manager) && Objects.equals(name, other.name)
				&& Objects.equals(owner, other.owner) && Objects.equals(receipt, other.receipt)
				&& foodstatus == other.foodstatus && foodtype == other.foodtype;
	}

	
	
	
	
}
