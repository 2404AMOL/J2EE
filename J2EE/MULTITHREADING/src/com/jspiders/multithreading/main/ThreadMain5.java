package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread5;

public class ThreadMain5 {

	public static void main(String[] args) {
		
		MyThread5 myThread5 = new MyThread5();
		myThread5.start();
		System.out.println("Thread ID : "+myThread5.getId());
		System.out.println("Thread Name : "+myThread5.getName());
		System.out.println("Thread Priority :"+myThread5.getPriority());
		System.out.println("Thread State : "+myThread5.getState());
		
	}
}
