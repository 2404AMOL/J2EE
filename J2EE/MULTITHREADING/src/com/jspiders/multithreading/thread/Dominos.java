package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Pizza;

public class Dominos extends Thread {

	private Pizza pizza;

	public Dominos(Pizza pizza) {
		super();
		this.pizza = pizza;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		pizza.bakedPizza(5);
	}
}
