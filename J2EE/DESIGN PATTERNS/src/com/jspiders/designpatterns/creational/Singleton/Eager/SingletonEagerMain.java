package com.jspiders.designpatterns.creational.Singleton.Eager;

public class SingletonEagerMain {

	public static void main(String[] args) {
		
		SingletonEager object1 = SingletonEager.getObject();
		SingletonEager object2 = SingletonEager.getObject();
		SingletonEager object3 = SingletonEager.getObject();
		System.out.println(object1);
		System.out.println(object2);
		System.out.println(object3);
	}
}
