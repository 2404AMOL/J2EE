package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Pizza;

public class Friends extends Thread {

	private Pizza pizza;

	public Friends(Pizza pizza) {
		super();
		this.pizza = pizza;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		pizza.orderPizza(5);
	}
	
}
