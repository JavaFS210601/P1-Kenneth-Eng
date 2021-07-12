/**
 * 
 */
package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Kenneth Eng
 *
 */
public class ConnectionUtilities {
	private static Logger log = LogManager.getLogger( ConnectionUtilities.class);
	
//	public ConnectionUtilities() {
//		
//	}
	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			//c = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("db"), prop.getProperty("pw"));
			
			String url = System.getenv("JDBC_URL");
			String username = System.getenv("JDBC_NAME");
			String password = System.getenv("JDBC_PASSWORD"); 
			
			c = DriverManager.getConnection(url,
					username , password);
			System.out.println("Opened database successfully");
		} catch (Exception e) {
			log.error("In PostgreSQLConnect: Fail to connect the database with the given properties");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return c;
	}
}
