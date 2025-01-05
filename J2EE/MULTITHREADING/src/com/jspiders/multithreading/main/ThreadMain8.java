package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread8;

public class ThreadMain8 {

	public static void main(String[] args) {
		
		MyThread8 myThread8 = new MyThread8();
		
		myThread8.setName("Thread-8");
		myThread8.setPriority(8);
		myThread8.start();
	}
}
