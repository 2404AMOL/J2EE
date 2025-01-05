package com.jspiders.DeSerialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.Object.User;

@SuppressWarnings("unused")
public class DeSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File file = new File("Serialization.txt");
		
		if (file.exists()) {
			
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream  objectInputStream = new ObjectInputStream(fileInputStream);
			
			//Here Dynamic Method Dispatch Method Overidding(Run Time polymorphism happing)
			//Object class contain toString() and child class has also toString() method
//			Object object = objectInputStream.readObject();
//			System.out.println(object);
			//Downcasting from ObjecInputStream to user Class
			
			User user =(User) objectInputStream.readObject();
			System.out.println(user);
			System.out.println("Object is Read From The File");
			objectInputStream.close();
			fileInputStream.close();
		}
		else {
			System.out.println("File Does Not Exists");
		}
	}
}
