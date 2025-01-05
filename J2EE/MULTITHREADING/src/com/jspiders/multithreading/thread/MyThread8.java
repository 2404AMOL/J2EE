package com.jspiders.multithreading.thread;

public class MyThread8 extends Thread {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 1; i <=5; i++) {	
			if (i == 3) {
				stop();
			}
			System.out.println(getName()+" Is Now Running");
		}
	}
}
