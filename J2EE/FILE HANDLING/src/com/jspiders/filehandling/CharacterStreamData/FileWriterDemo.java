package com.jspiders.filehandling.CharacterStreamData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		
		File file = new File("Demo.txt");
		
		if (file.exists()) {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Data From The Java Program");
			System.out.println("Data Is Written To The File");
			fileWriter.close();
		}
		else {
			file.createNewFile();
			System.out.println("File Is Created");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Data From The Java Program");
			System.out.println("Data Is Written To The File");
			fileWriter.close();
		}
	}
}
