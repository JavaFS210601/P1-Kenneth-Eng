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
@Table(name = "ticket_type")
public class TicketType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_type_id" )
	private int ticketTypeId;
	
	@Column(name = "ticket_type")
	private String ticketType;
	
	@OneToMany(mappedBy="ticketType", fetch=FetchType.EAGER)
	private List<Ticket> typeList = new ArrayList<>();

	public TicketType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketType(int ticketTypeId, String ticketType) {
		super();
		this.ticketTypeId = ticketTypeId;
		this.ticketType = ticketType;
	}

	public TicketType(String ticketType) {
		super();
		this.ticketType = ticketType;
	}

	public int getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(int ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	
	
}
