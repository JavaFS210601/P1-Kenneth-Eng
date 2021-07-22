/**
 * 
 */
package com.revature.services;

import java.io.BufferedReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.daos.TicketDao;
import com.revature.daos.deprecated.FoodDao;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketType;
import com.revature.models.deprecated.Food;
import com.revature.models.deprecated.FoodStatus;
import com.revature.models.deprecated.FoodTypes;

/**
 * Ticket service is an application layer object has 
 * functions to call on the DAO layer and provide services
 * to controllers.
 * 
 * @author Kenneth Eng
 *
 */
public class TicketService {
	private TicketDao ticketDao = new TicketDao();
	
	/*
	 * Insert method used to insert tickets 
	 * @param ticket - ticket object which holds the data
	 */
	public boolean  insertTicket(Ticket ticket) {
		
		ticketDao.insertTicket(ticket);;
		return true;
	}
	
	/*
	 * A method used to insert tickets 
	 * @param id - integer id of the ticket
	 */
	public boolean approveTicketById(int id) {
		Ticket ticket = ticketDao.getTicketById(id);
		TicketStatus ts = ticketDao.getTicketStatusById(2);
		ticket.setTicketStatus(ts);
		Date now = new Date();
		Timestamp updateDate = new Timestamp(now.getTime());
		ticket.setResolveDate(updateDate);
		System.out.println(ticket.getTicketStatus().getTicketStatus() + "----------------------------");
		ticketDao.updateTicket(ticket);
		//ticketDao.apprveTicketByTicketId( id);
		return true;
	}
	
	/*
	 * Insert method used to update ticket's status to reject 
	 * @param id - integer id of the ticket
	 */
	public boolean rejectTicketById(int id) {
		Ticket ticket = ticketDao.getTicketById(id);
		TicketStatus ts = ticketDao.getTicketStatusById(3);
		ticket.setTicketStatus(ts);
		Date now = new Date();
		Timestamp updateDate = new Timestamp(now.getTime());
		ticket.setResolveDate(updateDate);
		System.out.println(ticket.getTicketStatus().getTicketStatus() + "----------------------------");
		ticketDao.updateTicket(ticket);
		//ticketDao.apprveTicketByTicketId( id);
		return true;
		
	}
	
	/*
	 * A method used to retreive all tickets 
	 * 
	 */
	public List<Ticket> getAllTickets() {
		return ticketDao.findAllTickets();
	}
	
	/*
	 * A method used to retrive ticket by user id 
	 * @param userid - integer id of the user who craete this ticket
	 */
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

	/*
	 * Insert method used to insert tickets 
	 * @param type - the type of the ticket
	 */
	public List<Ticket> getTicketsByType(int type){
		return ticketDao.getTicketsByType(type);
	}
	
	/*
	 * A method used to get tickets from server by its status
	 * @param id - integer id of the ticket
	 */
	public List<Ticket> getTicketsByStatus(int status){
		return ticketDao.getTicketsByStatus(status);
	}
	
	/*
	 * A method used to get tickets by its type
	 * @param id - integer id of the ticket
	 */
	public List<TicketType> getAllTikcetTypes(){
		return ticketDao.getTickettypes();
	}
	
	/*
	 * A method used to get all Ticket Status 
	 * @param id - integer id of the ticket
	 */
	public List<TicketStatus> getAllTikcetStatus(){
		return ticketDao.getTicketStatus();
	}
	
	/*
	 * A method used to get tickets by its name
	 * @param id - integer id of the ticket
	 */
	public TicketType getTicketTypeByName(String name) {
		return ticketDao.getTicketTypeByName(name);
	}
	
	/*
	 * A method used to get ticket by its type id
	 * @param id - integer id of the ticket
	 */
	public TicketType getTicketTypeById(int id) {
		return ticketDao.getTicketTypeById(id);
	}
	
	/*
	 * A method used to get ticket by its status id
	 * @param id - integer id of the ticket
	 */
	public TicketStatus getTicketStatusById(int id) {
		return ticketDao.getTicketStatusById(id);
	}

	

}
