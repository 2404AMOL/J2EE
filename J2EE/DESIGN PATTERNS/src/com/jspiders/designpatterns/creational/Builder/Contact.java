package com.jspiders.designpatterns.creational.Builder;

public class Contact {

	private int id;
	private String firstName;
	private String lastName;
	private long mobileNo;
	private int age;
	private String gender;
	private String dob;
	private String emailString;
	private String address;
	private long pinCode;
	private long home;
	private long work;
	private long landline;
	
	public Contact(int id, String firstName, String lastName, long mobileNo, int age, String gender, String dob,
			String emailString, String address, long pinCode, long home, long work, long landline) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.emailString = emailString;
		this.address = address;
		this.pinCode = pinCode;
		this.home = home;
		this.work = work;
		this.landline = landline;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", age=" + age + ", gender=" + gender + ", dob=" + dob + ", emailString=" + emailString + ", address="
				+ address + ", pinCode=" + pinCode + ", home=" + home + ", work=" + work + ", landline=" + landline
				+ "]";
	}
}
