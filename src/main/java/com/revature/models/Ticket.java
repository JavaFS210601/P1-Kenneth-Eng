/**
 * 
 */
package com.revature.models;

import java.sql.Timestamp;

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

/**
 * User can create tickets for reimbursement as: LODGING, TRAVEL, FOOD, or OTHER 
 * 
 * @author Kenneth Eng
 *
 */

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id  // it makes it a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id") // it specific the name of the id field
	private int id;
	
	@Column(name = "ticket_name", nullable = false)
	private String name;
	
	@Column(name = "ticket_create_date", nullable = false)
	private Timestamp createDate;
	
	@Column(name = "ticket_resolve_date", nullable = false)
	private Timestamp resolveDate;
	
	@Column(name = "ticket_description")
	private String description;
	
	@Column(name = "ticket_amount",nullable = false)
	private double amount;
	
	@Column(name = "ticket_receipt")
	private String receipt;
	
	@ManyToOne(targetEntity=User.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User owner;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_type_id", nullable = false )
	private TicketType ticketType;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_status_id", nullable = false )
	private TicketStatus ticketStatus;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Ticket(int id, String name, Timestamp createDate, Timestamp resolveDate, String description, double amount,
			String receipt, User owner, TicketType ticketType, TicketStatus ticketStatus) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.amount = amount;
		this.receipt = receipt;
		this.owner = owner;
		this.ticketType = ticketType;
		this.ticketStatus = ticketStatus;
	}

	

	public Ticket(String name, Timestamp createDate, Timestamp resolveDate, String description, double amount,
			String receipt, User owner, TicketType ticketType, TicketStatus ticketStatus) {
		super();
		this.name = name;
		this.createDate = createDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.amount = amount;
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

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
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

	

	public String getDescription() {
		return description;
	}
	


	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", createDate=" + createDate + ", resolveDate=" + resolveDate
				+ ", description=" + description + ", receipt=" + receipt + ", owner=" + owner + ", ticketType="
				+ ticketType + ", ticketStatus=" + ticketStatus + "]";
	}


	
}
