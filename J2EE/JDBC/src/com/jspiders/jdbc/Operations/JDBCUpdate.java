package com.jspiders.jdbc.Operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {

	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	private static String query;
	
	public static void main(String[] args) {
		try {
			//1.Register The Driver
			//2.Open the Connection
			connection=openConnection();//Here it will directly return the connection reference
			//2.Create /Prepare the Statement
			statement=connection.createStatement();
			query="update student set Email='nihal@123@gmail.com' where id=6";
			
			int row=statement.executeUpdate(query);
			
			System.out.println(row+" row(s) affected");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	private static Connection openConnection() throws SQLException
	{
		//1.Register The Driver;
		driver=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//2.Open the Connection
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
		
	}
	
	private static void closeConnection() throws SQLException
	{
		if (connection!=null) {
			connection.close();
		}
		if (statement!=null) {
			statement.close();
		}
		DriverManager.deregisterDriver(driver);
	}
}
