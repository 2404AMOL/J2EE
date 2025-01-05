package com.jspiders.jdbc.Operations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSelect {

	private static Connection connection;
	@SuppressWarnings("unused")
	private static ResultSet resultSet;
	
	public static void main(String[] args) {
		try {
			// 1.Loads The Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2.Open The Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","root");
			
			// 3.Create / Prepare the Statements
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("Select * From Students");
			
			// 4.Process The Results
			System.out.println("======================================================");
			System.out.println("");
			System.out.println("======================================================");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
