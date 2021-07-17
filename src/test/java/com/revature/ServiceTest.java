/**
 * 
 */
package com.revature;

import javax.security.auth.login.LoginContext;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.services.TicketService;
import com.revature.services.UserService;

import antlr.collections.List;

/**
 * @author Kenneth Eng
 *
 */
public class ServiceTest {
	TicketService ticketService = new TicketService();
	UserService userService = new UserService();
	
	User tempUser = new User();
	Ticket tempTicket = new Ticket();
	
	UserRole tempRole = new UserRole();
	TicketType tempType = new TicketType();
	TicketStatus tempStatus = new TicketStatus();
	
	@BeforeAll 
	public static void init() {
		System.out.println("In BeforeAll");
		
		ServiceTest serviceTest = new ServiceTest();
	}
	
	@BeforeEach
	public void setBaseValues() {
		
		tempRole.setUserRole("manager");
		
		tempType.setTicketTypeId(1);
		tempType.setTicketType("food");
		tempStatus.setTicketStatusId(2);
		tempStatus.setTicketStatus("approved");
		
		tempUser.setUserId(1);
		tempUser.setUsername("kenng");
		tempUser.setUserrole(tempRole);
		
		tempTicket.setId(1);
		
		tempTicket.setOwner(tempUser);
		tempTicket.setTicketStatus(tempStatus);
		tempTicket.setTicketType(tempType);
		
	}
	
	@AfterEach
	public void clear() {
		System.out.println("In AfterEach");
		//reset values here
	}
	
	@Test
	public void testUserService() {
		//1 - login(String username, String password)
		// check if it is true (success) with define values
		  assertEquals(true, userService.login("kenng", "pwd"));
		
		//2 - register(String username, String password)
		// check if the defined values can register
		//  assertEquals(true, userService.register("ken2", "pwd"));
		
		//3 - findUserByName(String name) 
		// check if the return value matches the pre-define value
		 // assertEquals(tempUser.getUsername(), userService.findUserByName("Kenng"));
		
		//4 - getAllUsers()
		// check if it is list of User
		  assertEquals(ArrayList.class, userService.getAllUsers().getClass());
	
		  
		//5 - getUserById(int id)
		// check if the user id matches the defined id.
		  assertEquals(tempUser.getUserId(), userService.getUserById(1).getUserId());
	}
	
	@Test
	public void testTicketService() {
		//1 - insertTicket(Ticket ticket)
		 //assertEquals(ArrayList.class, );
		
		//2 - approveTicketById(int id)
		// check if the returned ticket id matches the given id 
		 assertEquals( true, ticketService.approveTicketById(1) );
		
		//3 - getAllTickets()
		// check if it is a list of Ticket object
		// assertEquals( tempTicket.getId(), ticketService.getAllTickets().get(0).getId() );
		 
		//4 - getTicketsByUserId(int userid)
		// check if the returned Ticket object has the correct id
		// assertEquals( tempTicket.getId(), ticketService.getTicketsByUserId(1) );
		
		//5 -  getTicketsByType(int type)
		// check if the returned Ticket object has the correct type
		// assertEquals( ArrayList.class, ticketService.getTicketsByType(1) );
		 
		//6 - getAllTikcetTypes()
		// check if the returned value is a list of Tickets 
		// assertEquals( List.class, ticketService.getAllTikcetTypes() );
		
		//7 - getTicketTypeById(int id)
		// check if returned Ticket has the correct id
		 assertEquals( tempType.getTicketTypeId(), ticketService.getTicketTypeById(1).getTicketTypeId() );
		 
		//8 - getTicketStatusById(int id)
		// check if returned Ticket has the correct status
		 assertEquals( tempStatus.getTicketStatusId(), ticketService.getTicketStatusById(2).getTicketStatusId() );
	}
}
