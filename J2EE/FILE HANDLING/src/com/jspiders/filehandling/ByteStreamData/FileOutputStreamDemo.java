package com.jspiders.filehandling.ByteStreamData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		File  file = new File("ByteData.txt");
		
		if (file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			
			fileOutputStream.write(1101);
			System.out.println("Data Is Written To The File");
			fileOutputStream.close();
		}
		else {
			file.createNewFile();
			System.out.println("File Is Created");
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			
			fileOutputStream.write(20);
			System.out.println("Data Is Written To The File");
			fileOutputStream.close();
		}
	}
}
