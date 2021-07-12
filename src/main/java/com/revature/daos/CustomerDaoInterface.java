/**
 * 
 */
package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;

/**
 * @author Kenneth Eng
 *
 */
public interface CustomerDaoInterface {
	
	public String getUserById();
	public String getUserByName();
	public String getUserByRole();
	public List<Customer> getAllCustomers();
	
}
