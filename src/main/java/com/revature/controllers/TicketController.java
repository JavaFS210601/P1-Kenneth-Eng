/**
 * 
 */
package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Food;
import com.revature.models.FoodTypes;
import com.revature.models.FoodsResponseDTO;
import com.revature.models.Manager;
import com.revature.models.NewTicketDTO;
import com.revature.models.RegisterDTO;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketType;
import com.revature.models.TicketsResponseDTO;
import com.revature.models.User;
import com.revature.models.UserRole;

import com.revature.services.TicketService;
import com.revature.services.UserService;

/**
 * @author Kenneth Eng
 *
 */
public class TicketController {
	//private FoodDao foodDao = new FoodDao();
	private TicketService ticketService = new TicketService();
	private ObjectMapper  om = new ObjectMapper();
	private UserService userService = new UserService();
	
	private List<TicketType> ticketTypesList;
	private List<TicketStatus> ticketStatusList;

	public void initTicketDB( HttpServletResponse res) throws IOException {
		
		
			
		//UserRole r1 = new UserRole(0, "manager");
		
		User u1 = userService.getUserById(1);
		//User u1 = new User("kenng"  , "pwd", "ken","eng" ,"a@a.com", r1);
		
		TicketType t1 =    new TicketType(0,"food");
		TicketStatus s1 = new TicketStatus(0, "approve");
		
		Date today = new Date();
		Timestamp createdate = new Timestamp(today.getTime());
		Timestamp resolvedate = new Timestamp(today.getTime());
		// name, owner id , type id , status id, 
		Ticket ticket1 = new Ticket("ticket 1",createdate, resolvedate , "description", 500.0, "" , u1, t1 , s1 ); // bean type id is 1 and owner id is 1
		//ticketService.insertTicket(ticket1);
		res.setStatus(200);
		
	}
	
	public void approveTicket(HttpServletResponse res, int id) throws IOException {
		ticketService.approveTicketById(id);
		res.getWriter().print("Ticket "+ id + " is approved");
		res.setStatus(200);
	}
	
	public void rejectTicket(HttpServletResponse res, int id) throws IOException {
		ticketService.rejectTicketById(id);
		res.getWriter().print("Ticket "+ id + " is approved");
		res.setStatus(200);
		
	}

	public void insertTicket(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder myStringBuilder = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			myStringBuilder.append(line);
			line = reader.readLine();
		}
		
		String body = new String(myStringBuilder);
		
		NewTicketDTO newTicketDTO = om.readValue(body, NewTicketDTO.class);
		
		
		//Manager m1 = userService.getManagerById(1);
		//UserRole r1 = userService.getUserRoleById(1);
	
		User u1 = userService.getUserById(newTicketDTO.getId());
		//UserRole r1= u1.getUserrole();
		
		// set the incoming ticket type
		TicketType t1 = ticketService.getTicketTypeByName(newTicketDTO.getType());
		
		// set the incoming ticket to pending
		TicketStatus s1 = ticketService.getTicketStatusById(1);
 
		Date today = new Date();
		Timestamp createdate = new Timestamp(today.getTime());
		Timestamp resolvedate = new Timestamp(today.getTime());
		Ticket ticket1 = new Ticket(newTicketDTO.getName(),createdate, resolvedate , newTicketDTO.getDescription(), newTicketDTO.getAmount(), "" , u1, t1, s1 );
		ticketService.insertTicket(ticket1);
		System.out.println(ticket1.toString());
		res.setStatus(200);
		
	}
	
	public void getTicketByUserId(HttpServletResponse res, int id )throws IOException {
		List<Ticket> tickets = ticketService.getTicketsByUserId(id);
		
		List<TicketsResponseDTO> ticketResponseList = new ArrayList<TicketsResponseDTO>();
		for(Ticket t : tickets) {
			//System.out.println(f.getId() + " " + f.getName() + " " + f.getFoodtype().toString() + f.getFoodstatus().toString());
			TicketsResponseDTO ticketResponse = new TicketsResponseDTO();
			ticketResponse.setId(t.getId());
			ticketResponse.setName(t.getName());
			ticketResponse.setReceipt(t.getReceipt());
			ticketResponse.setCreateDate(t.getCreateDate());
			ticketResponse.setResolveDate(t.getResolveDate());
			ticketResponse.setDescription(t.getDescription());
			ticketResponse.setAmount(t.getAmount());
			ticketResponse.setOwner(t.getOwner().getUsername());
			ticketResponse.setTicketType(t.getTicketType().getTicketType());
			ticketResponse.setTicketStatus(t.getTicketStatus().getTicketStatus());
			ticketResponseList.add(ticketResponse);
		}
		
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String json = om.writeValueAsString(ticketResponseList);
		System.out.println(json);
		res.getWriter().print(json);
		
		res.setStatus(200);
	}
	
	public void getTicketsByType(HttpServletResponse res, String type) throws IOException {
		//insertTicket( res);
		
		String type1 = type.toLowerCase();
		int id = 0;
		ticketTypesList = ticketService.getAllTikcetTypes();
		for (TicketType t: ticketTypesList ) {
			
			if (type1.equals(t.getTicketType())) {
				id = t.getTicketTypeId();
				break;
			}
			
		}
		
		List<Ticket> tickets = ticketService.getTicketsByType(id);
		
		List<TicketsResponseDTO> ticketResponseList = new ArrayList<TicketsResponseDTO>();
		for(Ticket t : tickets) {
			//System.out.println(f.getId() + " " + f.getName() + " " + f.getFoodtype().toString() + f.getFoodstatus().toString());
			TicketsResponseDTO ticketResponse = new TicketsResponseDTO();
			ticketResponse.setId(t.getId());
			ticketResponse.setName(t.getName());
			ticketResponse.setReceipt(t.getReceipt());
			ticketResponse.setCreateDate(t.getCreateDate());
			ticketResponse.setResolveDate(t.getResolveDate());
			ticketResponse.setDescription(t.getDescription());
			ticketResponse.setAmount(t.getAmount());
			ticketResponse.setOwner(t.getOwner().getUsername());
			ticketResponse.setTicketType(t.getTicketType().getTicketType());
			ticketResponse.setTicketStatus(t.getTicketStatus().getTicketStatus());
			ticketResponseList.add(ticketResponse);
		}
		
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String json = om.writeValueAsString(ticketResponseList);
		System.out.println(json);
		res.getWriter().print(json);
		
		res.setStatus(200);
	}
	
	public void getTicketsByStatus(HttpServletResponse res, String type) throws IOException {
		//insertTicket( res);
		
		String type1 = type.toLowerCase();
		int id = 0;
		ticketStatusList = ticketService.getAllTikcetStatus();
		for (TicketStatus t: ticketStatusList ) {
			
			if (type1.equals(t.getTicketStatus())) {
				id = t.getTicketStatusId();
				break;
			}
			
		}
		
		List<Ticket> tickets = ticketService.getTicketsByStatus(id);
		
		List<TicketsResponseDTO> ticketResponseList = new ArrayList<TicketsResponseDTO>();
		for(Ticket t : tickets) {
			//System.out.println(f.getId() + " " + f.getName() + " " + f.getFoodtype().toString() + f.getFoodstatus().toString());
			TicketsResponseDTO ticketResponse = new TicketsResponseDTO();
			ticketResponse.setId(t.getId());
			ticketResponse.setName(t.getName());
			ticketResponse.setReceipt(t.getReceipt());
			ticketResponse.setCreateDate(t.getCreateDate());
			ticketResponse.setResolveDate(t.getResolveDate());
			ticketResponse.setDescription(t.getDescription());
			ticketResponse.setAmount(t.getAmount());
			ticketResponse.setOwner(t.getOwner().getUsername());
			ticketResponse.setTicketType(t.getTicketType().getTicketType());
			ticketResponse.setTicketStatus(t.getTicketStatus().getTicketStatus());
			ticketResponseList.add(ticketResponse);
		}
		
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String json = om.writeValueAsString(ticketResponseList);
		System.out.println(json);
		res.getWriter().print(json);
		
		res.setStatus(200);
	}
	
	public void loadAllTickets(HttpServletResponse res) throws IOException{
		System.out.println("Hello from Food Controller");
		
		//initDB();
		//insertFood(res); 
		List<Ticket> tickets = ticketService.getAllTickets();
		
		
		List<TicketsResponseDTO> ticketsResponseList = new ArrayList();
		for(Ticket f : tickets) {
			//System.out.println(f.getId() + " " + f.getName() + " " + f.getFoodtype().toString() + f.getFoodstatus().toString());
			TicketsResponseDTO ticketsResponse = new TicketsResponseDTO();
			ticketsResponse.setId(f.getId());
			ticketsResponse.setName(f.getName());
			ticketsResponse.setAmount(f.getAmount());
			ticketsResponse.setReceipt(f.getReceipt());
			ticketsResponse.setCreateDate(f.getCreateDate());
			ticketsResponse.setResolveDate(f.getResolveDate());
			ticketsResponse.setOwner(f.getOwner().getUsername());
			ticketsResponse.setTicketStatus(f.getTicketStatus().getTicketStatus());
			ticketsResponse.setTicketType(f.getTicketType().getTicketType() );
			ticketsResponseList.add(ticketsResponse);
		}
		
		// Construct the response here
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String json = om.writeValueAsString(ticketsResponseList);
		res.getWriter().print(json);
		
		res.setStatus(200);
		
		
	}


}
