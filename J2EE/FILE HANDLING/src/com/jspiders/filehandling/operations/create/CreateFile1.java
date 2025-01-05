package com.jspiders.filehandling.operations.create;

import java.io.File;

public class CreateFile1 {

	public static void main(String[] args) {
		File file = new File("Hello.txt");
		
		if (file.exists()) {
			System.out.println("File Is Already Exists");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File Is Created");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
