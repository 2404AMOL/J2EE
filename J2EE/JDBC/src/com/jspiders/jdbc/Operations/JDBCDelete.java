package com.jspiders.jdbc.Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCDelete {

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
			statement = connection. createStatement();
			query = "delete from students where StudentID = 3";
			
			int row = statement.executeUpdate(query);
			System.out.println(row+ " rows(s) affected");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws SQLException {
		// 1.Register the Driver
		driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// 2.Open The Connection
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","root");
	}
	
	private static void closeConnection () throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement!=null) {
			statement.close();
		}
		DriverManager.deregisterDriver(driver);
	}
}
