package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Select1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.Load The Driver
			//1st Way
//			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2nd way
			//1.Register The Driver
			Driver driver= new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			//2.Open The Connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3?user=root&&password=root");
			
		//2.Create/Prepare the Statement
			Statement statement=connection.createStatement();
			
		//3.Create/Prepare Statement
			String queryString="insert into student values(03,'Ashutosh','Niakwadi',9757566565,'ashutosh71@gmail.com')";
			statement.executeUpdate(queryString);
			
		//4.Process The result
			
			System.out.println("Row Is Inserted");

		//5.Close The Connection
			connection.close();
			statement.close();
			
		//6.De-Register The Driver
			DriverManager.deregisterDriver(driver);
			
	}
}
