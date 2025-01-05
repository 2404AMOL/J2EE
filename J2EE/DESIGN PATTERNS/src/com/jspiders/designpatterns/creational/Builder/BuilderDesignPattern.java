package com.jspiders.designpatterns.creational.Builder;

public class BuilderDesignPattern {

	public static void main(String[] args) {
		
		Contact contact = new ContactBuilder().setFirstName("Amol").setLastName("Pawar").buildContact();
		System.out.println(contact);
	}
}
