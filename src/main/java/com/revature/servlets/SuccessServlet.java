package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {
	
	//any request comes in will be handled by this object
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html"); 
		
		PrintWriter pw = res.getWriter();
		
		pw.print("<h2> This is a success login! weclome " + req.getParameter("userId") + "</h2>");
	}
}
