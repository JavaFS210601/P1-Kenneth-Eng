/**
 * 
 */
package com.revature.daos.deprecated;

import java.util.List;

import com.revature.models.deprecated.Customer;

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
