package com.jspiders.designpatterns.creational.Factory;

import java.util.Scanner;

public class FactoryDesignPattern {

	private static Beverage beverage;
	
	public static void main(String[] args) {
		try {
			//Beverage beverage=factory();
			//beverage.order();
			factory().order();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Beverage factory() {
		System.out.println("Select the Tea Order.");
		System.out.print("1.Normal Tea \n2.Black Tea \n3.Green Tea \n4.Ice Tea\n===>");
		
		try(Scanner scanner = new Scanner(System.in)){
			int choice = scanner.nextInt();
			
			switch(choice) {
				
				case 1 : 
						beverage = new NormalTea();
						break;
				case 2 : 
						beverage = new BlackTea();
						break;
				case 3 : 
						beverage = new GreenTea();
						break;
				case 4 : 
						beverage = new IceTea();
						break;
				default : 
						System.out.println("Invaid Choice");
			}
		}
		return beverage;
	}
}
