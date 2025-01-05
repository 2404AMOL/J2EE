package com.jspiders.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



public class PreparedStatementInsert {

	private static Connection connection;
	private static java.sql.PreparedStatement preparedStatement;
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Entet The Student Id");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter The First Name");
		String fname=scanner.nextLine();
		System.out.println("Enter The Last Name");
		String lname=scanner.nextLine();
		System.out.println("Enter The Contact");
		long contact=scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter The Gmail");
		String gmail=scanner.nextLine();
		
		
		try {
			//1.Loads The Driver
			//2.Open the Connection
			connection=openConnection();
			
			//3.Create/Prepare Statement
			preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");
			
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,fname);
			preparedStatement.setString(3, lname);
			preparedStatement.setLong(4, contact);
			preparedStatement.setString(5, gmail);
			
			int row=preparedStatement.executeUpdate();
			
			System.out.println(row+"row(S) affected");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws SQLException, ClassNotFoundException
	{
		//1.Register The Driver;
		Class.forName("com.mysql.cj.jdbc.Driver");

		
		//2.Open the Connection
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
		
	}
	private static void closeConnection() throws SQLException
	{
		if (connection!=null) {
			connection.close();
		}
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
	
	}
}
