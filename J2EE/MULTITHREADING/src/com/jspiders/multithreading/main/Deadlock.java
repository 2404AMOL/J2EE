package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Resource;
import com.jspiders.multithreading.thread.MyThread10;
import com.jspiders.multithreading.thread.MyThread9;

public class Deadlock {

	public static void main(String[] args) {
		
		Resource resource = new Resource();
		
		MyThread9 myThread9 = new MyThread9(resource);
		MyThread10 myThread10 = new MyThread10(resource);
		
		myThread9.setName("T9");
		myThread10.setName("T10");
		myThread9.start();
		myThread10.start();
	}
}
