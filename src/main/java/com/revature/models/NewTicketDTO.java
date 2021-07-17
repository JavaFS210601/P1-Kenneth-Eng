package com.revature.models;

public class NewTicketDTO {
		
	//e.g. {"id":"2","username":"ocean","amount":"sfdsfds","description":"dsfdsfdsfdsfsdfsdfs","type":"lodging"}
	
	int id;
	String username;
	String name;
	double amount;
	String description;
	String type;
	
	public NewTicketDTO(int id, String username, String name, double amount, String description, String type) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.amount = amount;
		this.description = description;
		this.type = type;
	}
	
	
	public NewTicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
