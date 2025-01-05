package com.jspiders.jdbc.Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1st Way
		// 1.Loads the Driver
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2nd Way
		// 1.Register The Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// 2.Open The Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","root");
		
		// 3.Create / Prepare The Statement
		Statement statement = connection.createStatement();
		String queryString = "insert into Students values('3','Ganesh','Gidde','9370049100','gideeganesh07')";
		statement.executeUpdate(queryString);
		
		// 4.Process The Result
		System.out.println("Row is Inserted");
		
		// 5.Close The Connection
		connection.close();
		statement.close();
		
		// 6.De-Register The Driver
		DriverManager.deregisterDriver(driver);
		
	}
}
