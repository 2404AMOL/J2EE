package com.jspiders.multithreading.thread;

public class MyThread4 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		for (int i = 1; i <= 5; i++) {
			
			System.err.println("MyThread 4 is Running Now");
		}
	}
}
