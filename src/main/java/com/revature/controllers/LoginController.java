/**
 * 
 */
package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

/**
 * @author Kenneth Eng
 *
 */
public class LoginController {

	private ObjectMapper  om = new ObjectMapper();
	private LoginService loginService = new LoginService();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
			if (req.getMethod().equals("POST")) {
				BufferedReader reader = req.getReader();
				
				StringBuilder myStringBuilder = new StringBuilder();
				
				String line = reader.readLine();
				
				while (line != null) {
					myStringBuilder.append(line);
					line = reader.readLine();
				}
				
				String body = new String(myStringBuilder);
				
				// readValue method of object mapper can read json string into an object
				LoginDTO loginDTO = om.readValue(body, LoginDTO.class);
				
				if (loginService.login(loginDTO.username, loginDTO.password)) {
					// this one will create a session if there are none.
					HttpSession session = req.getSession();
					
					if (req.getCookies() != null) {
						for ( javax.servlet.http.Cookie c :req.getCookies()) {
							System.out.print(c.getName() + " " + c.getValue());
							
						}
					}
					//System.out.println(loginDTO.username+" "+ loginDTO.password);
					
					
					session.setAttribute("username", loginDTO.username);
					session.setAttribute("loggedin", true);
					String name = (String)session.getAttribute("username");
					System.out.print(name);
					res.setStatus(200);
					res.getWriter().print("Hi, Login was successful");
				
				} else {
					// false: this only return a session if one is already login in
					HttpSession session = req.getSession(false);
					
					if (session != null) {
						session.invalidate();
					}
					res.setStatus(401); // unauthorized
					res.getWriter().print("Login Invalidated");
				}
			}
		
	}

}
