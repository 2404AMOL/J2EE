package com.jspiders.Serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.Object.User;

public class Serialization {

	public static void main(String[] args) throws IOException {
		
		File file = new File("Serialization.txt");
		
		if (file.exists()) {
			System.out.println("File Is Already Exist");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new User(24, "Amol", "24amolpawar@gmail.com", "Amol2404@"));
			System.out.println("Object Is Written To The File");
			fileOutputStream.close();
			objectOutputStream.close();
		}
		else {
			file.createNewFile();
			System.out.println("File IS Created");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new User(24, "Amol", "24amolpawar@gmail.com", "Amol2404@"));
			System.out.println("Object is Written To The File");
			fileOutputStream.close();
			objectOutputStream.close();
		}
	}
}
