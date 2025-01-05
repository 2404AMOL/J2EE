package com.jspiders.jdbc.JDBC_STEPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

//############################# CODE STANDARDLIZATION ##################################
//If you don't pass the database name in the connection properties then
//you can pass in the query itself.
//databaseName.TableName
//"INSERT into weja3.Student Values(...)"
public class Type3 {
	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	private static String query;
	
	public static void main(String[] args) throws SQLException {
	
		try {
			// 1.Register The Driver
			// 2.Open The Connection
			connection = openConnection();
			// 3.Create / Prepare the Statement
			statement = connection.createStatement();
			//If you does not provide the database then you have pass the databaseName.
			//Here for accessing the database into query
			query = "INSERT into j2ee.Students values (3,'Ganesh','Gidde',9370049100,'giddeganesh07@gmail.com')";
			
			// 4.Process the Result
			int row = statement.executeUpdate(query);
			System.out.println(row+" row(s) affected");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
	private static Connection openConnection() throws SQLException {
		//1.Register The Driver
		driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//2.Open The Connection
		return DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
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
