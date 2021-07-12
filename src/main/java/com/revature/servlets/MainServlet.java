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
import com.revature.controllers.LoginController;

/**
 * @author Kenneth Eng
 *
 */
public class MainServlet extends HttpServlet{
	private CustomerController cc = new CustomerController();
	private FoodController foodController = new FoodController();
	private LoginController loginController= new LoginController();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("application/json");
		
//		res.setContentType("text/html");
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
//		dispatcher.forward(req, res);
	
		res.setStatus(404);

		String URI = req.getRequestURI().replace("/P1-Kenneth-Eng/", "");
		// make a log here to debug the URI 
		System.out.println("URI" +URI);
		URI = URI.replace("/", "");
		switch(URI) {
			case "food": 
				foodController.loadAllFood();
				break;
			case "customers": 
				
				// false means it will not create a new one.
				if (req.getSession(false) != null) {
					if (req.getCookies() != null) {
						System.out.println("hello from customer. this is your cookies");
						for ( javax.servlet.http.Cookie c :req.getCookies()) {
							System.out.print(c.getName() + " " + c.getValue());
							
						}
					}
						
					//cc.getAllCustomers(res); 
					foodController.loadAllFood();
				} else {
					res.setStatus(403);
				}
				
				
				break;
		
			case "foods":
				foodController.loadAllFood();
			case "login":
				loginController.login(req, res);
				break;
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("application/html");
		res.setStatus(404);

		String URI = req.getRequestURI().replace("/P1-Kenneth-Eng/", "");

		switch(URI) {
		
			case "customers": 
				
				// false means it will not create a new one.
				//if (req.getSession(false) != null) {
					System.out.println("hello from customer");
					cc.getAllCustomers(res); 
				//} else {
					
				//}
				
				
				break;
			case "login":
				loginController.login(req, res);
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
