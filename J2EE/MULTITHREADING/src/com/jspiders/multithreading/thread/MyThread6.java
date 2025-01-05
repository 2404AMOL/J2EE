package com.jspiders.multithreading.thread;

public class MyThread6 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Name of Thread : "+getName());
		System.out.println("Priority of Thread "+getPriority());
	}
	
}
