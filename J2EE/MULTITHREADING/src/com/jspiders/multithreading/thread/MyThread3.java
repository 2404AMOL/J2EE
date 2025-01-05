package com.jspiders.multithreading.thread;
public class MyThread3 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 1; i <= 5 ; i++) {
			
			System.out.println("MyThread 3 Is Now Running");
		}
	}
}
