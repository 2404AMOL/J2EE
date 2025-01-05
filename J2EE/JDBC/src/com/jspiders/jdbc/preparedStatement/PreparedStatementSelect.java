package com.jspiders.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementSelect {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter The Student Id \n==>");
		int id=scanner.nextInt();
		
		try {
			//1.Loads The Driver
			//2.Open the Connection
			connection=openConnection();
			
			//3.Create/Prepared Statement
//			query="Select * from student";
			query="Select * from student where id=?";

			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			//4.Process The result
			resultSet=preparedStatement.executeQuery();
			System.out.println("===================================================");
			System.out.println("ID || Frist Name || Last Name || Contact || Gmail");
			System.out.println("===================================================");

			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+" || "
					+resultSet.getString(2)+ " || "
					+resultSet.getString(3)+ " || "
					+resultSet.getLong(4)+ " || "
					+resultSet.getString(5)
				);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws ClassNotFoundException, SQLException
	{
		//1.Load The Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Open The Connection
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
		
	}
	private static void closeConnection() throws SQLException
	{
		if (preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection!=null) {
			connection.close();
		}
	}
}
