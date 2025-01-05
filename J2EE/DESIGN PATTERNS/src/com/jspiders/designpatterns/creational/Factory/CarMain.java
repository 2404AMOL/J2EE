package com.jspiders.designpatterns.creational.Factory;

import java.util.Scanner;

public class CarMain {

	private static Car car;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			carApp().order();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static Car carApp() {
		System.out.println("Select To Car Buy");
		System.out.print("1.Audi \n2.Suv \n3.Porshe \n4.BMW \n===>");
		int choice = scanner.nextInt();
		try {
			switch (choice) {
			case 1 : car = new Audi();
					break;
			
			case 2 : car = new Suv();
					break;
			case 3 : car = new Porshe();
					break;
			case 4 :car = new BMW();
					break;
			default:
					System.out.println("Invalid Choice");
					break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return car;
	}
}
