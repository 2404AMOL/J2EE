package com.jspiders.filehandling.ByteStreamData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException {
		
		File file = new File("ByteData.txt");
		
		if (file.exists()) {
			
			FileInputStream fileInputStream = new FileInputStream(file);
			System.out.println("Data Fetched From The File : "+fileInputStream.read());
			fileInputStream.close();
		}
		else {
			System.out.println("File Is Not Present");
		}
	}
}
