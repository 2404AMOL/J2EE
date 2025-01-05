package com.jspiders.multithreading.thread;

public class Process1 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()+" ...Starts");
			try {
				this.wait();
				
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"...Notified");
		}
	}
	
	
}
