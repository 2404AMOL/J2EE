package com.jspiders.multithreading.thread;

public class Process2 extends Thread {

	Process1 process1;
	
	public Process2(Process1 process1)
	{
		this.process1 = process1;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this.process1)
		{
			System.out.println(Thread.currentThread().getName()+"...Starts");
			
			try {
				this.process1.wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"...notified");
		}
	}
}
