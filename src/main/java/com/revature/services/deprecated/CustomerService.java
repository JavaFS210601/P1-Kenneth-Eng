/**
 * 
 */
package com.revature.services.deprecated;

import java.util.List;

import com.revature.daos.deprecated.CustomerDao;
import com.revature.daos.deprecated.CustomerDaoInterface;
import com.revature.models.deprecated.Customer;

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
