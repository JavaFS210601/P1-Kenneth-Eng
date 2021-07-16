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
@Table(name = "ticket_status")
public class TicketStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_status_id" )
	private int ticketStatusId;
	
	@Column(name = "ticket_status")
	private String ticketStatus;
	
	@OneToMany(mappedBy="ticketStatus", fetch=FetchType.EAGER)
	private List<Ticket> statusList = new ArrayList<>();

	public TicketStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketStatus(int foodStatusId, String foodStatus) {
		super();
		this.ticketStatusId = foodStatusId;
		this.ticketStatus = foodStatus;
	}

	public TicketStatus(String foodStatus) {
		super();
		this.ticketStatus = foodStatus;
	}

	public int getTicketStatusId() {
		return ticketStatusId;
	}

	public void setTicketStatusId(int foodStatusId) {
		this.ticketStatusId = foodStatusId;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String foodStatus) {
		this.ticketStatus = foodStatus;
	}
	
	
	
}
