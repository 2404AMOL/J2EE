package com.jspiders.cardekho_case_study.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Properties;
import java.util.Scanner;



public class CarOperation {
	
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static ResultSet resultSet;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filePath = "D:\\QSPIDER WAKAD\\J2EE\\PROJECTS\\PROJECT 2\\CarDekho_Case_Study\\resources\\db_info2.properties";
	private static String query;
	
	static Scanner scanner=new Scanner(System.in);



	public void addCar()
	{
		try {
			openConnection();
			System.out.println();
			System.out.print("==>How many Car Deatils You Want Add : \t");
			int choice2=scanner.nextInt();
			for(int i=1;i<=choice2;i++)
			{
				System.out.println();
				System.out.println("===========================================================================");
				System.out.print("Enter the Car ID : ");
				int ID=scanner.nextInt();
				System.out.print("Enter The Car Name : ");
				String Name=scanner.next();
				System.out.print("Enter The Brand Name : ");
				String Brand=scanner.next();
				System.out.print("Enter The Fuel Type : ");
				String FuelType=scanner.next();
				System.out.print("Enter The Price : ");
				double Price=scanner.nextDouble();	
				System.out.println("===========================================================================");
				System.out.println("======== Car Added Successfully...!!! ============");
				System.out.println("===========================================================================");
				System.out.println("\t\t***********  CAR	DEKHO  **************");	
				System.out.println("===========================================================================");
				System.out.println("Car ID \t"+"Car Name \t"+"Car Brand \t"+"Car Price \t"+"Car FueType");
				System.out.println("===========================================================================");
				System.out.println(ID+"\t"+Name+"\t\t"+Brand+"\t\t"+FuelType+"\t\t"+Price);
				
				query = "insert into car_dekho "
						+ "values (" + ID + ",'"
						+ Name + "','"+Brand+"','" + FuelType + "'," + Price + ")";
				result = result + statement.executeUpdate(query);
			}
			System.out.println("Query OK, " + result 
					+ " row(s) affected.");
			scanner.close();
			System.out.println();
			System.out.println("===========================================================================");
			System.out.println("Information Is Added Successfully...!!!");
			System.out.println("===========================================================================");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
	
	public void searchCar() {
		
		try {
			openConnection();
			
			query = "select * from car_dekho";
			resultSet = statement.executeQuery(query);
			

			if(resultSet.next()) {
				System.out.println("----->>>> No Car Found..!");
			}
			else {
				System.out.println("=========Serach By=========");
				System.out.println("1.Name \n2.Brand \n3.Fule Type \n4.Go Back");
				System.out.println("Enter Your Choice : ");
				switch(scanner.nextInt()) {
					
				case 1:
					System.out.print("Enter the Car Name :\t");
					String name=scanner.next();
					
					
					query="select * from car_dekho where car_name in('"+name+"')";
					resultSet = statement.executeQuery(query);
					
					while (resultSet.next()) {
						System.out.println("Car Id"+" | "+"Car Name "+" | "+"Car Brand"+" | "+"Car FuelType"+" | "+"Car Price");
						System.out.println(resultSet.getString(1) + "  \t  "+resultSet.getString(2) + " \t   "
								+resultSet.getString(3) + " \t "+resultSet.getString(4)+" \t "+resultSet.getString(5));
					}
					
					break;
				case 2:
					System.out.println("Enter the Car brand :");
					String brand=scanner.next();
					
					query="select * from car_dekho where car_brand in('"+brand+"')";
					resultSet = statement.executeQuery(query);
					
					while (resultSet.next()) {
						System.out.println("Car Id"+" | "+"Car Name "+" | "+"Car Brand"+" | "+"Car FuelType"+" | "+"Car Price");
						System.out.println(resultSet.getString(1) + "  \t  "+resultSet.getString(2) + " \t   "
								+resultSet.getString(3) + " \t "+resultSet.getString(4)+" \t "+resultSet.getString(5));
					}
				
					break;
				case 3:
					System.out.println("Enter the Car Fuletype :");
					String fuletype=scanner.next();
					
					query="select * from car_dekho where car_fueltype in('"+fuletype+"')";
					resultSet = statement.executeQuery(query);
					
				
					
					break;
				case 4:
					return;
				default:
					System.out.println("Enter the valid choice..!");
				
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	
	}
	
	public void updateCar() 
	{
		
		try {
			openConnection();
			query = "select * from car_dekho";
			resultSet = statement.executeQuery(query);
			
			if(resultSet == null) {
				
				System.out.println("------->>>>> No Car IS Found ....!!!");
			}else {
				
				System.out.println("Enter the Car id to update Car details..!");
				int carId=scanner.nextInt();
				
				System.out.println("What would you like to update..!");
				System.out.println("1.Name \n2.Model \n3.Brand \n4.Fule Type \n5.Price");
				switch(scanner.nextInt()) {
				case 1:
					System.out.println("Enter the name");
					String carName=scanner.next();
					
					
					
					query="update car_dekho set car_name = '"+carName+"'"+"where car_id in ('"+carId+"')";
					result = statement.executeUpdate(query);
					
					avaiableCars();

					
					System.out.println("Name is Updated..!");
					break;
					
					

				case 2:
					System.out.println("Enter the Brand");
					String carBrand=scanner.next();
					
					query="update car_dekho set car_brand = '"+carBrand+"'"+"where car_id in ('"+carId+"')";
					result = statement.executeUpdate(query);
					
					avaiableCars();
					
					System.out.println("Brand Updated..!");
					break;
				case 4:
					System.out.println("Enter the Fule Type");
					String CarFuelType=scanner.next();
					
					query="update car_dekho set car_fueltype = '"+CarFuelType+"'"+"where car_id in ('"+carId+"')";
					result = statement.executeUpdate(query);
					avaiableCars();

					System.out.println("Fule Type Updated..!");
					break;
				case 5:
					System.out.println("Enter the Price");
					Double carPrice=scanner.nextDouble();
					
					query="update car_dekho set car_price = '"+carPrice+"'"+"where car_id in ('"+carId+"')";
					result = statement.executeUpdate(query);
					avaiableCars();

					System.out.println("Price Updated..!");
					break;
				default:
					System.out.println("Enter the valid choice..!");
				}	
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	
	}
	
	public void deleteCar() {
		try {
			openConnection();
			query = "select * from car_dekho";
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				System.out.println("Enter the Car ID :");
				int carID=scanner.nextInt();
				
				query="delete from car_dekho where car_Id in ('"+carID+"')";
				result = statement.executeUpdate(query);
				
				System.out.println("----------------------------------------------");
				System.out.println(" >>>>>>>>>>>	Record Deleted	<<<<<<<<<<<< ");
				System.out.println("----------------------------------------------");
				
				avaiableCars();
				
			}
			else
			{
				System.out.println("Cars Not Avaibles..!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}

	}
	
	public void avaiableCars() {
		
		try {
			openConnection();
			
			query = "select * from car_dekho";
			resultSet = statement.executeQuery(query);
			
			System.out.println("----------------------------------------------");
			System.out.println(" >>>>>>>>>>>	Avaibale Cars	<<<<<<<<<<<< ");
			System.out.println("----------------------------------------------");
			
			System.out.println("Car Id"+" | "+"Car Name "+" | "+"Car Brand"+" | "+"Car FuelType"+" | "+"Car Price");
			while (resultSet.next()) {	
				System.out.println(resultSet.getString(1) + " \t "+resultSet.getString(2) + " \t   "
						+resultSet.getString(3) + " \t "+resultSet.getString(4)+" \t "+resultSet.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		
		
		
		
	}
	
	
	
	
	private static void openConnection() {
		try {
			file = new FileInputStream(filePath);
			properties.load(file);
			Class.forName(properties.getProperty("driverPath"));
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"), properties);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (file != null) {
				file.close();
			}
			if (result != 0) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
