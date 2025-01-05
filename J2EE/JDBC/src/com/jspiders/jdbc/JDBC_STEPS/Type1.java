package com.jspiders.jdbc.JDBC_STEPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Type1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1.Loads The Driver
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		//			or
		
		// 1.Register The Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// 2.Open The Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&&password=root");
		
		// 3.Create / Prepare Statement
		Statement statement = connection.createStatement();
		String query = "insert into students values(01,'Amol','Pawar',9373428581,'24amolpawar@gmail.com')";
		statement.executeUpdate(query);
		
		// 4.Process The Result
		System.out.println("Row Is Inserted");
		
		// 5.Close The Connection
		connection.close();
		statement.close();
		
		// 6.De-Register Driver
		DriverManager.deregisterDriver(driver);
		
	}
}
