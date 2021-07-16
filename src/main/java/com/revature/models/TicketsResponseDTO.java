/**
 * 
 */
package com.revature.models;

import java.sql.Timestamp;

/**
 * @author Kenneth Eng
 *
 */
public class TicketsResponseDTO {
	int id;
	String name;
	Timestamp createDate;
	Timestamp resolveDate;
	double amount;
	String description;
	String receipt;
	String owner;
	String ticketType;
	String ticketStatus;
	public TicketsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TicketsResponseDTO(int id, String name, Timestamp createDate, Timestamp resolveDate, double amount,
			String description, String receipt, String owner, String ticketType, String ticketStatus) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.resolveDate = resolveDate;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.owner = owner;
		this.ticketType = ticketType;
		this.ticketStatus = ticketStatus;
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
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getResolveDate() {
		return resolveDate;
	}
	public void setResolveDate(Timestamp resolveDate) {
		this.resolveDate = resolveDate;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
