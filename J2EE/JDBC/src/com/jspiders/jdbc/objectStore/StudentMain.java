package com.jspiders.jdbc.objectStore;

import java.sql.SQLException;
import java.util.Scanner;


public class StudentMain {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		boolean login=true;
		
		StudentJDBC jdbc=new StudentJDBC();
		
		System.out.println("*******************************************************************");
		System.out.println("======================== STUDENT DATA =========================== ");
		System.out.println("*******************************************************************");
		
		while(login)
		{
			System.out.println("===============================================================");
			System.out.print("Enter Your choice : \n1.Add Student \n2.Get All Student Deatails \n3.Fetch Using ID \n4.Update The Details \n5.Exit "+
					"\n============================================================================="+
					"\n==>");
			int choice=scanner.nextInt();
			
			switch (choice) {
			case 1:
				Student student = new Student();
				System.out.println("Enter Student ID");
				student.setId(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter The First Name");
				student.setFname(scanner.nextLine());
				System.out.println("Enter The Last Name");
				student.setLname(scanner.nextLine());
				System.out.println("Enter The Contact");
				student.setContact(scanner.nextLong());
				scanner.nextLine();
				System.out.println("Enter The Gmail");
				student.setGmail(scanner.nextLine());
				
				jdbc.addStudentDetails(student);

				break;
				
			case 2:
				jdbc.getDetails();
				break;
			case 3:
					jdbc.getUsingID();
				break;
			case 4:
					jdbc.updateData();
				break;
			case 5:
				System.out.println("THANK YOU");
					login=false;		
			default:
				System.out.println("Invalid Choice");
			}

		}
		
	}
}
