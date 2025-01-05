package com.jspiders.filehandling.operations.create;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {
		
		File file = new File("Demo.txt");
		
		try {
			file.createNewFile();
			System.out.println("File Is Created");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
