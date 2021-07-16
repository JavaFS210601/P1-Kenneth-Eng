/**
 * 
 */
package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Food;
import com.revature.models.Manager;
import com.revature.utils.HibernateUtil;

/**
 * @author Kenneth Eng
 *
 */
public class ManagerDao {

	public Manager getManagerById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		// create a new food object by getting data from database with the id.
		Manager manager = ses.get(Manager.class, id);
		
		HibernateUtil.closeSession();
		
		return manager;
	}
}
