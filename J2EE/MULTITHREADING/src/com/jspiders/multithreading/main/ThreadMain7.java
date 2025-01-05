package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread7;

public class ThreadMain7 {

	public static void main(String[] args) {
		
		MyThread7 myThread7 = new MyThread7();
		Thread thread = new Thread(myThread7);
		thread.setName("Thread-7");
		thread.setPriority(7);
		thread.start();
	}
}
