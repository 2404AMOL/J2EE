package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Resource;

public class MyThread10 extends Thread {

	Resource resource;
	
	public MyThread10(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (resource.res2) {
			System.out.println(getName()+" Applied Lock On "+resource.res2);
			
			synchronized(resource.res1) {
				System.out.println(getName()+ " Applied Lock On "+resource.res1);
			}
			System.out.println(getName()+" Released "+resource.res1);
		}
		System.out.println(getName()+" Released "+resource.res2);
	}
}
