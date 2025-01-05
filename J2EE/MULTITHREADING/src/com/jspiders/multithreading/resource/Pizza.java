package com.jspiders.multithreading.resource;

public class Pizza {

	private int avaialablePizza;
	
	public  synchronized void orderPizza(int orderedPizza) {
		System.out.println("Trying To Order : "+orderedPizza+" Pizzas");
		
		if (avaialablePizza < orderedPizza) {
			System.out.println(orderedPizza+" Pizzas Not Available "+" Please Wait");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		avaialablePizza -= orderedPizza;
		
		System.out.println(orderedPizza+ " Pizzas Delivered ");
		System.out.println(avaialablePizza+" Pizzas Available ");
	}
	public synchronized void bakedPizza(int bakedPizza)
	{
		System.out.println("Baking "+bakedPizza+" Pizzas");
		avaialablePizza += bakedPizza;
		System.out.println(bakedPizza+" Pizzas Baked");
		System.out.println(avaialablePizza+" Pizzas Available ");
		this.notify();
	}
	
	 
}
