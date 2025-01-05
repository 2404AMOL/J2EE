package com.jspiders.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdate {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter The Email");
		String email=scanner.nextLine();
		
		System.out.println("Enter The Id");
		int id=scanner.nextInt();
		
		try {
			//1.Loads The Driver
			connection=openConnection();
			
			//3.Create/Prepare Statement
			
			query="update student set Email=? where id=? ";
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);
			int row=preparedStatement.executeUpdate();
			
			System.out.println(row+"row(S) affected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}
	
	private static Connection openConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	
	private static void closeConnection()
	{
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
