package com.jspiders.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDelete {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static Scanner scanner =new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.print("Enter The Student Id To Want To Delete the Record \n==>");
		int id=scanner.nextInt();
		scanner.close();
		
		try {
			//1.Open the Connection
			//2.Loads the Driver
			connection=openConnection();
			
			query="Delete from student where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			
			//3.Process The Result
			int row=preparedStatement.executeUpdate();
			
			System.out.println(row+" row(S) affected");

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
		if (preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
