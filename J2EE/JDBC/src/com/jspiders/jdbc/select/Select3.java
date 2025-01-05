package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//############################# CODE STANDARDLIZATION ##################################
//If you don't pass the database name in the connection properties then
//you can pass in the query itself.
//databaseName.TableName
//"INSERT into weja3.Student Values(...)"
public class Select3 {
	
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
			//If you does not provide the database then you have pass the databaseName.
			//Here for accessing the database into query
			query="INSERT into weja3.Student Values(07,'Nihal','Shaikh',46646466464,'nihal@.com')";
			
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
		return DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		
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
