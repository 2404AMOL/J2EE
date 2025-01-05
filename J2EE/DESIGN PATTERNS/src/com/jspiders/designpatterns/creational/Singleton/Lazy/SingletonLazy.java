package com.jspiders.designpatterns.creational.Singleton.Lazy;

public class SingletonLazy {

	//Lazy means We have not initialized the Object Reference variable FIrstly
	private static SingletonLazy singletonLazy;

	private SingletonLazy() {
		
	}
//	Here we declare the Static method because we did not create the Object
// Constructor is Private	
	static public SingletonLazy getObject()
	{
		//if Object Reference is null then Create the object
		if (singletonLazy == null) {
			singletonLazy = new SingletonLazy();
		}
		//if object is Already created then return the Reference
		return singletonLazy;
	}
	
}
