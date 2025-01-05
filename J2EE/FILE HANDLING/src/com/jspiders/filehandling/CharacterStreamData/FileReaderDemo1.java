package com.jspiders.filehandling.CharacterStreamData;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderDemo1 {

	public static void main(String[] args) throws IOException {
		
		File file = new File("Demo.txt");
		
		if (file.exists()) {
			FileReader fileReader = new FileReader(file);
			
//			int res = fileReader.read();
			System.out.println("Data Is Feteched Using File Reader : "+fileReader.read());//Returns ASCII Value of the First Character
			fileReader.close();
			
			Scanner scanner = new Scanner(file);
			
//			for(;scanner.hasNext();)
//			{
//					System.out.println("Data Fetched Using Scanner :"+scanner.nextLine());
//
//			}
			while(scanner.hasNext())//Checking the Multiple lines
			{
				System.out.println("Data Fetched Using Scanner :"+scanner.nextLine());
				//String res=scanner.nextLine();
			}
			scanner.close();
		}
		else {
			System.out.println("File Is Not Exits");
		}
	}
}
