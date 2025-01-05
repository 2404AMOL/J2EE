package com.jspiders.designpatterns.creational.Singleton.Eager;

public class SingletonEager {

	private static SingletonEager singletonEager = new SingletonEager();

	private SingletonEager() {
		// TODO Auto-generated constructor stub
	}
	
	public static SingletonEager getObject()
	{
		return singletonEager;
	
	}
}
