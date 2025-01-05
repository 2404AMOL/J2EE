package com.jspiders.jdbc.JDBC_STEPS;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//******************************************** CODE STANDARDLIZATION ************************************************
public class Type2 {

	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	private static String query;
	
	public static void main(String[] args) {
		try {
			// 1.Register The Driver
			
			// 2.Open The Connection
			connection = openConnection();//Here it will directly return the connection reference
			
			// 3.Create / Prepare The Statement
			statement = connection.createStatement();
			query = "INSERT into Students Values(2,'Rohit','Nalwade','9374798765','rohit@gmail.com')";
			
			//4.Process The Result
			int row = statement.executeUpdate(query);
			System.out.println(row+" row(s) affected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws SQLException {
		// 1.Register The Driver
		
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		// 2.Open The Connection
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","root");
		
	}
	
	private static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();
		}
		DriverManager.deregisterDriver(driver);
	}
}
