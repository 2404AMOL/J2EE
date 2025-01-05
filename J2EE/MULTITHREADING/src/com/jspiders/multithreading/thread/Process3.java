package com.jspiders.multithreading.thread;

public class Process3 extends Thread {

	Process1 process1;
	 
	 public Process3(Process1 process1) 
	    { 
	    	this.process1 = process1;
	    }
	    public void run()
	    {
	        synchronized (this.process1)
	        {
	            System.out.println(Thread.currentThread().getName()+ "...starts");
	            this.process1.notifyAll();
	            System.out.println(Thread.currentThread().getName()+ "...notified");
	        }
	    }
	
}
