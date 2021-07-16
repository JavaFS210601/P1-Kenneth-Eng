/**
 * 
 */
package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.FoodDao;
import com.revature.daos.TicketDao;
import com.revature.models.Food;
import com.revature.models.FoodStatus;
import com.revature.models.FoodTypes;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketType;

/**
 * @author Kenneth Eng
 *
 */
public class TicketService {
	private TicketDao ticketDao = new TicketDao();
	
	public boolean  insertTicket(Ticket ticket) {
		ticketDao.insertTicket(ticket);;
		return true;
	}
	
	public boolean approveTicketById(int id) {
//		Ticket ticket = ticketDao.getTicketById(id);
//		TicketStatus ts = ticketDao.getTicketStatusById(2);
//		ticket.setTicketStatus(ts);
//		System.out.println(ticket.getTicketStatus().getTicketStatus() + "----------------------------");
//		ticketDao.updateTicket(ticket);
		ticketDao.apprveTicketByTicketId( id);
		return true;
	}
	
	public List<Ticket> getAllTickets() {
		return ticketDao.findAllTickets();
	}
	
	public List<Ticket> getTicketsByUserId(int userid){
		List<Ticket> tickets= ticketDao.getTicketsByUserId(userid);
		List<Ticket> usersTickets = new ArrayList<>();
		for (Ticket ticket : tickets) {
			if (ticket.getOwner().getUserId() == userid) {
				usersTickets.add(ticket);
			}
		}
		
		return usersTickets;
	}
	
	public List<Ticket> getTicketsByType(int type){
		return ticketDao.getTicketsByType(type);
	}
	
	public List<TicketType> getAllTikcetTypes(){
		return ticketDao.getTickettypes();
	}
	
	public TicketType getTicketTypeById(int id) {
		return ticketDao.getTicketTypeById(id);
	}
	
	public TicketStatus getTicketStatusById(int id) {
		return ticketDao.getTicketStatusById(id);
	}
}
