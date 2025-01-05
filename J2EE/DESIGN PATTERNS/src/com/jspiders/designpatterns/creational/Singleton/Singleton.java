package com.jspiders.designpatterns.creational.Singleton;

public class Singleton {

	//Here we Created the Object Reference static

	private static Singleton singleton;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
//	Here we declare the Static method because we did not create the Object
// Constructor is Private
	static public Singleton getObject()
	{
		//if Object Reference is null then Create the object

		if (singleton == null) {
			singleton = new Singleton();
		}
		//if object is Already created then return the Reference
		return singleton;
	}
}
//Singleton Means Restrict the user to create the Multiple Object.
