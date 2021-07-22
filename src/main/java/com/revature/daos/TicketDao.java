/**
 * 
 */
package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Food;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketType;
import com.revature.utils.HibernateUtil;

/**
 * @author Kenneth Eng
 *
 */
public class TicketDao {
	public List<Ticket> findAllTickets() {

		Session ses = HibernateUtil.getSession();

		// Using HQL! Hibernate Query Language that references the java class
		// e.g. "Food" in our model package, instead of "Food" in database.

		List<Ticket> ticketList = ses.createQuery("FROM Ticket").list();
		// at the end, we are turing the results into a list

		HibernateUtil.closeSession();

		return ticketList;

	}
	

	public void updateTicket(Ticket ticket) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		tx = ses.beginTransaction();
		ses.merge(ticket);
		 tx.commit();
		HibernateUtil.closeSession();
	}
	
	public void apprveTicketByTicketId(int id) {
		Session ses = HibernateUtil.getSession();
		
		
		
//		Query query = ses.createQuery("UPDATE Ticket  SET ticketStatus = :statusid"
//				+ " WHERE id = :userid" );
//		 query.setParameter("statusid", 2);
//		 query.setParameter("userid", id);
		
		 
		HibernateUtil.closeSession();
	}

	public void insertTicket(Ticket ticket) {

		Session ses = HibernateUtil.getSession();

		ses.save(ticket);

		HibernateUtil.closeSession();
	}
	
	public List<Ticket> getTicketsByUserId(int id) {
		Session ses = HibernateUtil.getSession();

	
		List<Ticket> ticketList = ses.createQuery("FROM Ticket as ticket WHERE "
				+ " ticket.owner =  "+ id).list();

		HibernateUtil.closeSession();

		return ticketList;
	}

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
	
	public List<TicketStatus> getTicketStatus() {
		
		Session ses = HibernateUtil.getSession();
		
		List<TicketStatus> ticketStatus = ses.createQuery("FROM TicketStatus").list();
		
		HibernateUtil.closeSession();
		
		return ticketStatus;
	}

	public TicketType getTicketTypeById(int id) {
		Session ses = HibernateUtil.getSession();

		TicketType ticketType = ses.get(TicketType.class, id);

		HibernateUtil.closeSession();

		return ticketType;
	}
	
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
	
	public List<Ticket> getTicketsByStatus(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		String hql = "FROM Ticket WHERE ticket_status_id = " + id;

		List<Ticket> results = ses.createQuery(hql).list();
		return results;
	}


	public TicketType getTicketTypeByName(String name) {
		Session ses = HibernateUtil.getSession();

		String query = "FROM TicketType WHERE ticketType = :name" ;
		TicketType ticketType = (TicketType )ses.createQuery(query).setParameter("name", name).getSingleResult();

		HibernateUtil.closeSession();

		return ticketType;
	}
	
	
}
