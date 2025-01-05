package com.jspiders.jdbc.storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableDemo {

	private static Connection connection;
	//CallableStatement Interface is used to call the Stored Procedure 
	private static CallableStatement callableStatement;
	private static ResultSet resultSet;
	private static String query;
	public static void main(String[] args) {
		try {
			connection=openConnection();
			//Inside the query we have to pass the stored procedure call statement
			query="call p1()";
			
			callableStatement=connection.prepareCall(query);
			callableStatement.execute();
			resultSet=callableStatement.getResultSet();
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+" ||"
						+resultSet.getString(2)+ " || "
						+resultSet.getString(3)+ " || "
						+resultSet.getLong(4)+ " || "
						+resultSet.getString(5));
			}
		} catch (Exception e) {
			closeConnection();
		}
	}
	
	private static Connection openConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	private static void closeConnection()
	{
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (callableStatement!=null) {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
