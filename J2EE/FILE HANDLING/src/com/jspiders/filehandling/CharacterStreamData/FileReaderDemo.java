package com.jspiders.filehandling.CharacterStreamData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		
		File file = new File("Demo.txt");
		
		if (file.exists()) {
			FileReader fileReader = new FileReader(file);
			
//			int res = fileReader.read();
			System.out.println("Data Is Fetched Using File Reader : "+fileReader.read());//Returns ASCII Value of the First Character
			fileReader.close();
		}
		else {
			System.out.println("File Is Not Exists");
		}
	}
}
