/**
 * 
 */
package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtilities;

/**
 * deprecated JDBC dao object 
 * 
 * @author Kenneth Eng
 *
 */
public class CustomerDao implements CustomerDaoInterface {
	
	
	public List<Customer> getAllCustomers() {
			try(Connection conn = ConnectionUtilities.getConnection()){
			
			String sql = "SELECT * FROM ers_users;"; //write your sql statement to send to the DB
			
			Statement s = conn.createStatement(); //create a statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet 
												//(Execute the query into it!)
			
			List<Customer> customerList = new ArrayList<>(); //create a new ArrayList to hold all the Avengers
			
			
			
			while(rs.next()) { //while there are still rows in our ResultSet
				
				//make a new Avenger object for each row
				Customer a = new Customer (
					rs.getInt("user_id"),
					rs.getString("user_username"),
					rs.getString("user_password"),
					rs.getString("user_firstname"),
					rs.getString("user_lastname"),
					rs.getString("user_email"),
					rs.getInt("user_role_id")
					//null //here's the fun part, I'll add the Home object below
				);
				
				//if the Avenger DOES have a home...
				//if(rs.getString("home_fk") != null) {
					//a.setHome_fk(hDAO.getHomeByName(rs.getString("home_fk")));
					//set the Avenger's home_fk equal to the home object returned by getHomeByName
					//the getHomeByName method gets its parameter from the home_fk column returned by the SQL query
					//in this way, we can get an entire Home object with just our home_fk!
					
					//the logic given as a parameter in the setHome_fk() method will return a Home object...
					//and set it as the Home field in the new Avenger object
				//}
				
				//after creating the Avenger object, and adding a home_fk field if it exists, add it to the ArrayList
				customerList.add(a);
			}
			
			//outside our while loop, once all avengers have been added, return the ArrayList
			return customerList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all avengers failed!");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	/*
	 * 
	 */
	@Override
	public String getUserById(){
		try(Connection con = ConnectionUtilities.getConnection()){
			
			
		}catch(SQLException s) {
			System.out.print(s);
		}
		return null;
		
	}

	/*
	 * 
	 */
	@Override
	public String getUserByName() {

		return null;
	}

	/*
	 * 
	 */
	@Override
	public String getUserByRole() {

		return null;
	}
	
}
