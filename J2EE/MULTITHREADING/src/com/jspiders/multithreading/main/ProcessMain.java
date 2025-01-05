package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.Process1;
import com.jspiders.multithreading.thread.Process2;
import com.jspiders.multithreading.thread.Process3;

public class ProcessMain {

	public static void main(String[] args)  throws InterruptedException
	{
		 	Process1 process1 = new Process1();
	        Process2 process2 = new Process2(process1);
	        Process3 process3 = new Process3(process1);
	        
	        Thread t1 = new Thread(process1, "Process-1");
	        Thread t2 = new Thread(process2, "Process-2");
	        Thread t3 = new Thread(process3, "Process-3");
	        t1.start();
	        t2.start();
	        Thread.sleep(100);
	        t3.start();
	}
}
