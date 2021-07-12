package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Not Used 
 * 
 * @author Kenneth Eng
 *
 */
public class LoginServlet extends HttpServlet{
	private static final Logger log = LogManager.getLogger(LoginServlet.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		pw.print("<h1>Hello from your login method doGet method </h1>");
		
		res.setStatus(200);
	}

//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
//		//log.info("Login servlet is called!");
//		PrintWriter pw = res.getWriter();
//		//userId   password
//		String username = req.getParameter("userId");
//		String password = req.getParameter("password");
//		
//		//call login method to check database and if the user is found 
//		//return 200
//		RequestDispatcher rd  = null;
//		
//		//normally, checking the user credentials will be done in 
//		// server layer. For now, hardcode th username and password
//		if (username.equals("username") && password.equals("wassword")) {
//			rd = req.getRequestDispatcher("success");
//			rd.forward(req, res);
//		} else {
//			rd = req.getRequestDispatcher("index.html");
//			rd.include(req, res);
//			pw.print("<p style='color:red'>LOGIN FAILTED</p> ");
//		}
// 		//res.setStatus(200);
//	}
}
