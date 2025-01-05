package com.jspiders.multithreading.thread;

public class MyThread7 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Id Of Thread :- "+Thread.currentThread().getId());
		System.out.println("Name Of Thread :- "+Thread.currentThread().getName());
		System.out.println("Name Of Thread :- "+Thread.currentThread().getPriority());
	}
}
