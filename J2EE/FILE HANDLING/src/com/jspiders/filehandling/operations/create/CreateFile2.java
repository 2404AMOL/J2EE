package com.jspiders.filehandling.operations.create;

import java.io.File;

public class CreateFile2 {

	public static void main(String[] args) {
		
		File file = new File("File.txt");
		File file1 = new File("File.mp3");
		File file2 = new File("File.mp4");
		File file3 = new File("File.pdf");
		
		if (file.exists()) {
			System.out.println("File Is Already Exists");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("===> Text File Is Created");
				file1.createNewFile();
				System.out.println("===> MP3 File Is Created");
				file2.createNewFile();
				System.out.println("===> MP4 File Is Created");
				file3.createNewFile();
				} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
