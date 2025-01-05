package com.jspiders.designpatterns.creational.Singleton;

public class SingletonMain {

	public static void main(String[] args) {
////		1st Way
////		Singleton.getObject();
////		System.out.println(Singleton.getObject());
//		
		//2nd Way
		Singleton object1 = Singleton.getObject();
		Singleton object2 = Singleton.getObject();
		Singleton object3 = Singleton.getObject();
		System.out.println(object1);
		System.out.println(object2);
		System.out.println(object3);
	}
}
