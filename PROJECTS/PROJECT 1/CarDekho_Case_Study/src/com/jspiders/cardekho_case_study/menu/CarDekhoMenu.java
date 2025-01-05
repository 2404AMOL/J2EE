package com.jspiders.cardekho_case_study.menu;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.operation.CarOperation;


public class CarDekhoMenu {
	static boolean login=true;
	static Scanner scanner=new Scanner(System.in);
	public static void main(String args[]) throws Exception
	{	
		CarOperation carOperation=new CarOperation();
		
		while(login)
		{
			System.out.println("=============== MENU ===================");
			System.out.print("1.Add Car Details\n"+"2.Search Car Details\n"+"3.Update car Details\n"+"4.Delete Car Deatails\n"+"5.Available Cars\n"+"6.Exit\n"
								+"\n Enter Your Choice :\t");
			int choice =scanner.nextInt();
			switch(choice)
			{
			case 1:
				carOperation.addCar();
				break;
				
			case 2:
				carOperation.searchCar();
				break;
				
			case 3:
				carOperation.updateCar();
				break;
				
			case 4:
				carOperation.deleteCar();
				break;
				
			case 5:
				carOperation.avaiableCars();
				break;
				
			case 6:
					login=false;
					System.out.println("===========================================================================");
					System.out.println("------->>>>> Thanks for Using CarDhekho...!!! ----------->>>>>");
					System.out.println("===========================================================================");
				break;
			
			default:
				System.out.print("Invalid Option..! choose Valid option");

			}

		}
	}
	
}
