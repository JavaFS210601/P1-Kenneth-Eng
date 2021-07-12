/**
 * 
 */
package com.revature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests:
 * 
 * Connection , login eethod , register method
 * success page
 * 
 * @author Kenneth Eng
 *
 */
public class ServeletTest {
	// Test objects
	
	
	//test values
	
	
	@BeforeAll 
	public static void init() {
		System.out.println("In BeforeAll");
	}
	
	@BeforeEach
	public void setBaseValues() {
		System.out.println("In BeforeEach");
	}
	
	@AfterEach
	public void clear() {
		System.out.println("In AfterEach");
		//reset values here
	}
	
	@Test
	public static void testConnection() {
		
	}
	
	@Test
	public static void testLoginServlet() {
		
	}
	
	@Test
	public static void testSuccessServlet() {
		
	}
}
