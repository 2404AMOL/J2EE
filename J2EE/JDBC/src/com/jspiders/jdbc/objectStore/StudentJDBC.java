package com.jspiders.jdbc.objectStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class StudentJDBC {

	private static Connection connection;
	private static ResultSet resultSet;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static Scanner scanner=new Scanner(System.in);
	
	public void addStudentDetails(Student student) throws ClassNotFoundException, SQLException
	{
		connection=openConnection();
			
		query="Insert Into student values(?,?,?,?,?)";
		preparedStatement=connection.prepareStatement(query);
			
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2,student.getFname());
		preparedStatement.setString(3,student.getLname());
		preparedStatement.setLong(4,student.getContact());
		preparedStatement.setString(5,student.getGmail());
			
		int result = preparedStatement.executeUpdate();
			
		System.out.println(result+" row(S) affected");
			
		closeConnection();
							
	}
	
	public void getDetails() throws ClassNotFoundException, SQLException
	{
		connection=openConnection();
		
		query="SELECT * FROM STUDENT ";
		
		statement=connection.createStatement();
		
		resultSet=statement.executeQuery(query);
		

		System.out.println("===================================================");
		System.out.println("ID || Frist Name || Last Name || Contact || Gmail");
		System.out.println("===================================================");
		
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt(1)+ " || "
					+ resultSet.getString(2)+ " || "
					+ resultSet.getString(3)+ " || "
					+ resultSet.getLong(4)+ " || "
					+ resultSet.getString(5));
		}
		
		closeConnection();
	}
	
	public void getUsingID() throws ClassNotFoundException, SQLException
	{
		
		connection=openConnection();
		
		System.out.print("Enter The Student ID \n==>");
		int id=scanner.nextInt();
		
		query="SELECT * FROM STUDENT where ID=?";
		
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		resultSet=preparedStatement.executeQuery();
		

		System.out.println("===================================================");
		System.out.println("ID || Frist Name || Last Name || Contact || Gmail");
		System.out.println("===================================================");
		
		if(resultSet.next())
		{
			System.out.println(resultSet.getInt(1)+" || "
				+resultSet.getString(2)+ " || "
				+resultSet.getString(3)+ " || "
				+resultSet.getLong(4)+ " || "
				+resultSet.getString(5)
			);
		}
		closeConnection();
	}
	
	public void updateData() throws ClassNotFoundException, SQLException
	{
		connection=openConnection();
		
		System.out.println("Enter What You want To Update");
		System.out.print("\n1.ID \n2.First Name \n3.Last Name \n4.Contact \n5.Gmail");
		
		
		closeConnection();
		
	}

	private static Connection openConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	private void closeConnection() throws SQLException
	{
		if (connection!=null) {
			connection.close();
		}
		if (resultSet!=null) {
			resultSet.close();
		}
	}
}
