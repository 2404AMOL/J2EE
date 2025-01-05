package com.jspiders.jdbc.batchProcess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ExecuteBatchInsert {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		
		
		
		try {
			connection=openConnection();
			
			query="Insert into student values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			
			System.out.println("Enter What Number Records wants to Add");
			int input=scanner.nextInt();
			
			for(int i=1;i<=input;i++)
			{
				System.out.print("Enter The Student Id \n==>");
				int id=scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("Enter The First Name \n==>");
				String fname=scanner.nextLine();
				
				System.out.print("Enter The Last Name \n==>");
				String lname=scanner.next();
				
				System.out.print("Enter The Contact \n==>");
				long contact=scanner.nextLong();
				scanner.nextLine();
				
				System.out.print("Enter The Gmail \n==>");
				String gmail=scanner.nextLine();
				
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2,fname);
				preparedStatement.setString(3,lname);
				preparedStatement.setLong(4,contact);
				preparedStatement.setString(5,gmail);
				preparedStatement.addBatch();
			}
			

			int res[]=preparedStatement.executeBatch();
			System.out.println(res.length+" row(S) affected");
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
