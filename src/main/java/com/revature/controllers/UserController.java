/**
 * 
 */
package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Customer;
import com.revature.models.LoginDTO;
import com.revature.models.RegisterDTO;
import com.revature.models.User;
import com.revature.models.UserResponseDTO;
import com.revature.services.UserService;

/**
 * @author Kenneth Eng
 *
 */
public class UserController {

	private ObjectMapper  om = new ObjectMapper();
	private UserService userService = new UserService();
	
	public void getAllUsers(HttpServletResponse res) throws IOException{
		
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		List<UserResponseDTO> userResponseList = new ArrayList<>();
		
		List<User> userlist = userService.getAllUsers();
		
		if (userlist != null) {
			for (User user :userlist) {
				 String s = user + " ";
				 System.out.println(s);
				 
				 UserResponseDTO userResponse = new UserResponseDTO();
				 
				 userResponse.setUserid( user.getUserId());
				 userResponse.setUsername(user.getUsername());
				 //userResponse.setPassword(user.getPassword());
				 userResponse.setFirstname(user.getFirstname());
				 userResponse.setLastname(user.getLastname());
				 userResponse.setUserrole(user.getUserrole().getUserRole());
				 
				 userResponseList.add(userResponse);
			}
		}
		String json = om.writeValueAsString( userResponseList);
		
		//put the JSON into the response object (res)
		
		res.getWriter().print(json);
		//res.getWriter().flush();
		//override the default 404 status code that we set in the MasterServlet
		res.setStatus(200);
		System.out.println("hello from customer controller");
	}
	
	public void register(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("registering customer");
		if( req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			
			StringBuilder myStringBuilder = new StringBuilder();
			
			String line = reader.readLine();
			
			while (line != null) {
				myStringBuilder.append(line);
				line = reader.readLine();
			}
			
			String body = new String(myStringBuilder);
			
			RegisterDTO registerDTO = om.readValue(body, RegisterDTO.class);
			//System.out.println(body);
			if (userService.register(registerDTO.username, registerDTO.password, registerDTO.getEmail(), registerDTO.getRole()) ) {
				
				
				//userService.register(registerDTO.username, registerDTO.password, registerDTO.getRole() );
				
				res.setStatus(200);
				res.getWriter().print("Hi, Register was successful");
			} else {
				res.setStatus(403);
				res.getWriter().print("Hi, Register failed. Please try again");
			}
		}
		
	}
	public void autoLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		
		if (req.getCookies() != null) {
			for ( javax.servlet.http.Cookie c :req.getCookies()) {
				System.out.println(c.getName() + " " + c.getValue());
				//cookieName = c.getName();
				//cookieValue = c.getValue();
			}
		}
		
		
		String name = (String)session.getAttribute("username");
		String pwd = (String)session.getAttribute("password");
//		User user = userService.getUserByUserByUsernameAndPassword(name, pwd);
//		
//		 UserResponseDTO userResponse = new UserResponseDTO();
//		 
//		 userResponse.setUserid( user.getUserId());
//		 userResponse.setUsername(user.getUsername());
//		 //userResponse.setPassword(user.getPassword());
//		 userResponse.setFirstname(user.getFirstname());
//		 userResponse.setLastname(user.getLastname());
//		 userResponse.setUserrole(user.getUserrole().getUserRole());
//		
//		 String json = om.writeValueAsString( userResponse);
		 
		System.out.println("auto login " + name + pwd);
		res.setStatus(200);
		//res.getWriter().print(json);
		res.getWriter().print("success");
	}
	
	private String prepareUserDTO(String name, String pwd) throws IOException{
		User user = userService.getUserByUserByUsernameAndPassword(name, pwd);
		
		 UserResponseDTO userResponse = new UserResponseDTO();
		 
		 userResponse.setUserid( user.getUserId());
		 userResponse.setUsername(user.getUsername());
		 //userResponse.setPassword(user.getPassword());
		 userResponse.setFirstname(user.getFirstname());
		 userResponse.setLastname(user.getLastname());
		 userResponse.setUserrole(user.getUserrole().getUserRole());
		
		 String json = om.writeValueAsString( userResponse);
		 
		 return json;
	}
	
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
				
				if (userService.login(loginDTO.username, loginDTO.password) )  {
					// this one will create a session if there are none.
					HttpSession session = req.getSession();
					
					String cookieName = "";
					String cookieValue = "";
					if (req.getCookies() != null) {
						for ( javax.servlet.http.Cookie c :req.getCookies()) {
							System.out.println(c.getName() + " " + c.getValue());
							cookieName = c.getName();
							cookieValue = c.getValue();
						}
					}
					//System.out.println(loginDTO.username+" "+ loginDTO.password);
					
					String json = prepareUserDTO(loginDTO.username, loginDTO.password);
					
					session.setAttribute(cookieName, cookieValue);
					session.setAttribute("username", loginDTO.username);
					session.setAttribute("password", loginDTO.password);
					session.setAttribute("loggedin", true);
					String name = (String)session.getAttribute("username");
					System.out.println(name);
					
					Cookie c1=new Cookie(cookieName,cookieValue);
					res.addCookie(c1);
					res.setStatus(200);
					res.getWriter().print(json);
				
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
