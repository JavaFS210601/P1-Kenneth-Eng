/**
 * 
 */
package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Customer;
import com.revature.services.CustomerService;
/**
 * @author Kenneth Eng
 *
 */
public class CustomerController {
	private CustomerService cs = new CustomerService();
	private ObjectMapper  om = new ObjectMapper();
	
	///ObjectMapper om = new ObjectMapper();

	public void getAllCustomers(HttpServletResponse res) throws IOException{
		
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		List<Customer> customerlist = cs.getAllCustomers();
		
		String json = om.writeValueAsString(customerlist );
		
		//put the JSON into the response object (res)
		
		res.getWriter().print(json);
		//res.getWriter().flush();
		//override the default 404 status code that we set in the MasterServlet
		res.setStatus(200);
		System.out.println("hello from customer controller");
	}
}
