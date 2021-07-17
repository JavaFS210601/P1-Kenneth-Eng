/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.CustomerController;
import com.revature.controllers.FoodController;
import com.revature.controllers.TicketController;
import com.revature.controllers.UserController;

/**
 * @author Kenneth Eng
 *
 */
public class MainServlet extends HttpServlet{
	private TicketController ticketController = new TicketController();
	//private CustomerController cc = new CustomerController();
	private FoodController foodController = new FoodController();
	private UserController userController= new UserController();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("application/json");
		
//		res.setContentType("text/html");
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
//		dispatcher.forward(req, res);
	
		res.setStatus(404);

		String URI = req.getRequestURI().replace("/P1-Kenneth-Eng/", "");
		// make a log here to debug the URI 
		URI = URI.toLowerCase();
		//URI = URI.replace("/", "");
		String[] URi = URI.split("/");
		System.out.println("URI " +URi[0]);
		switch(URi[0]) {
			case "employee":
				//if (URi[1].equals( "tickets") ) {
					System.out.println("retrieve employee tickets");
					ticketController.getTicketByUserId( res, Integer.valueOf(URi[1]) );
			//	}
				break;
			case "reject":
				if (URi[1] != null) {
				System.out.println("approve" + URi[1]);
				ticketController.rejectTicket(res, Integer.valueOf(URi[1]));
				//res.setStatus(200);
				} 
				break;
			case "approve":
				if (URi[1] != null) {
				System.out.println("approve" + URi[1]);
				ticketController.approveTicket(res, Integer.valueOf(URi[1]));
				//res.setStatus(200);
				} 
				break;
			case "tickets":
				System.out.println("create ticket.");
				//if (req.getSession(false) != null) {
					
				if (URi.length == 3) {
					ticketController.getTicketsByType(res, URi[2]);
				} else  {
					//ticketController.initTicketDB(res);
					ticketController.loadAllTickets( res);
				} 
				
				//}
				break;
			case "food": 
				foodController.loadAllFood(res);
				break;
			case "users": 
				
				// false means it will not create a new one.
				if (req.getSession(false) != null) {
					if (req.getCookies() != null) {
						System.out.println("hello from customer. this is your cookies");
						
					}	
					//userController.getAllUsers(res);
					res.setStatus(403);
					//foodController.loadAllFood();
				} else {
					//res.setStatus(403);
					userController.getAllUsers(res);
				}

				break;
		
			case "foods":
				if (req.getSession(false) != null) {
					//foodController.loadAllFood(res);
					foodController.getFoodByUserId(res);
				} else {
					res.setStatus(403);
				}
				break;
			case "type":
				if (URi.length == 2) {
					System.out.println("URI 2 " +URi[1]);
					//int typeid = Integer.valueOf(URi[1]);
					
					foodController.getFoodByType(res, URi[1]);
					
				}
				break;
			case "alltypes":
				foodController.getAllFoodTypes(res);
				break;
				
//			case "login":
//				userController.login(req, res);
//				break;
			
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("application/html");
		res.setStatus(404);

		String URI = req.getRequestURI().replace("/P1-Kenneth-Eng/", "");
		//URI = URI.replace("/", "");

		switch(URI) {
			case "open":
				System.out.println("open ticket begin");
				ticketController.insertTicket(req, res);
			break;
			case "users": 
				
				// false means it will not create a new one.
				if (req.getSession(false) != null) {
					System.out.println("hello from customer");
					userController.getAllUsers(res);
				} else {
					res.setStatus(403);
				}
				
				
				break;
			case "login":
				if (req.getSession(false) != null) {
					
//					req.getSession(false).getAttribute("username");
//					
					userController.autoLogin(req, res);
					
				
					//userController.login(req, res);
					
				} else {
					userController.login(req, res);
				}
				break;
				
			case "register":
				userController.register(req, res);
				break;
		}
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//		res.setContentType("text/html"); 
//		
//		PrintWriter pw = res.getWriter();
//		
//		pw.print("<h2> This is Food website " + req.getParameter("userId") + "</h2>");
//	}
}
