package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Not Used 
 * 
 * @author Kenneth Eng
 *
 */
public class HelloServlet extends HttpServlet{
	
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		pw.print("<h1>Hello from your doGet Method </h1>");
		
		res.setStatus(200);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		
		pw.print("<h1>Hello from your doGet Method </h1>");
		
		res.setStatus(200);
	}
}
