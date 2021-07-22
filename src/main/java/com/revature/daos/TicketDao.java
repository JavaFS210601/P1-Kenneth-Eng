/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketType;
import com.revature.models.deprecated.Food;
import com.revature.utils.HibernateUtil;

/**
 * The DAO object that are responsible for communicate with database using 
 * Hibernate to handle ticket data
 * 
 * @author Kenneth Eng
 *
 */
public class TicketDao {
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a list of all tickets
	 *  
	 */
	public List<Ticket> findAllTickets() {

		Session ses = HibernateUtil.getSession();

		// Using HQL! Hibernate Query Language that references the java class
		// e.g. "Food" in our model package, instead of "Food" in database.

		List<Ticket> ticketList = ses.createQuery("FROM Ticket").list();
		// at the end, we are turing the results into a list

		HibernateUtil.closeSession();

		return ticketList;

	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * update the ticket
	 * 
	 * param ticket - the ticket  to update
	 */
	public void updateTicket(Ticket ticket) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		tx = ses.beginTransaction();
		ses.merge(ticket);
		 tx.commit();
		HibernateUtil.closeSession();
	}
	

	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * insert a ticket to the database
	 * 
	 * param ticket - the ticket to be inserted
	 */
	public void insertTicket(Ticket ticket) {

		Session ses = HibernateUtil.getSession();

		ses.save(ticket);

		HibernateUtil.closeSession();
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a list tickets created by the user who has the given id
	 * 
	 * param id - the id of the user
	 */
	public List<Ticket> getTicketsByUserId(int id) {
		Session ses = HibernateUtil.getSession();

	
		List<Ticket> ticketList = ses.createQuery("FROM Ticket as ticket WHERE "
				+ " ticket.owner =  "+ id).list();

		HibernateUtil.closeSession();

		return ticketList;
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a ticket besed on the id 
	 * 
	 * param id - ticket id
	 */
	public Ticket getTicketById(int id) {

		Session ses = HibernateUtil.getSession();

		Ticket ticket = ses.get(Ticket.class, id);

		HibernateUtil.closeSession();

		return ticket;

	}
	
	public List<TicketType> getTickettypes() {
		
		Session ses = HibernateUtil.getSession();
		
		List<TicketType> ticketTypes = ses.createQuery("FROM TicketType").list();
		
		HibernateUtil.closeSession();
		
		return ticketTypes;
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a list of Ticket Status
	 * 
	 */
	public List<TicketStatus> getTicketStatus() {
		
		Session ses = HibernateUtil.getSession();
		
		List<TicketStatus> ticketStatus = ses.createQuery("FROM TicketStatus").list();
		
		HibernateUtil.closeSession();
		
		return ticketStatus;
	}

	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a list of ticket type
	 * 
	 * param id - the id of ticket type
	 */
	public TicketType getTicketTypeById(int id) {
		Session ses = HibernateUtil.getSession();

		TicketType ticketType = ses.get(TicketType.class, id);

		HibernateUtil.closeSession();

		return ticketType;
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a list of ticket status
	 * 
	 * param id - the id of the ticket status 
	 */
	public TicketStatus getTicketStatusById(int id) {
		
		Session ses = HibernateUtil.getSession();

		TicketStatus ticketStatus = ses.get(TicketStatus.class, id);

		HibernateUtil.closeSession();

		return ticketStatus;
	}

	public List<Ticket> getTicketsByType(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM Ticket WHERE ticket_type_id = " + id;

		List<Ticket> results = ses.createQuery(hql).list();
		return results;
	}
	
	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a list of ticket based on the type
	 * 
	 * param id - the id of the ticket status
	 */
	public List<Ticket> getTicketsByStatus(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM Ticket WHERE ticket_status_id = " + id;

		List<Ticket> results = ses.createQuery(hql).list();
		return results;
	}

	/*
	 * A method create hibernate session, HQL and perform the query and 
	 * return a list of tickets based its name
	 * 
	 * param name- the name of the type
	 */
	public TicketType getTicketTypeByName(String name) {
		Session ses = HibernateUtil.getSession();

		String query = "FROM TicketType WHERE ticketType = :name" ;
		TicketType ticketType = (TicketType )ses.createQuery(query).setParameter("name", name).getSingleResult();

		HibernateUtil.closeSession();

		return ticketType;
	}
	
	
}
