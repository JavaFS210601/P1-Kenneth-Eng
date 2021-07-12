/**
 * 
 */
package com.revature.services;

import java.util.List;

import com.revature.daos.CustomerDao;
import com.revature.daos.CustomerDaoInterface;
import com.revature.models.Customer;

/**
 * @author ocean
 *
 */
public class CustomerService {
private CustomerDaoInterface customerDao = new CustomerDao();
	
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
}
