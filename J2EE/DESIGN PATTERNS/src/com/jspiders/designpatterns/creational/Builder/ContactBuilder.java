package com.jspiders.designpatterns.creational.Builder;

public class ContactBuilder {

	private int id;
	private String firstName;
	private String lastName;
	private long mobile;
	private int age;
	private String gender;
	private String dobString;
	private String email;
	private String address;
	private int pincode;
	private long home;
	private long work;
	private long landline;
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public ContactBuilder setId(int id) {
		this.id = id;
		return this;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public ContactBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public ContactBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public ContactBuilder setMobile(long mobile) {
		this.mobile = mobile;
		return this;
	}
	/**
	 * @param age the age to set
	 */
	public ContactBuilder setAge(int age) {
		this.age = age;
		return this;

	}
	public ContactBuilder setGender(String gender)
	{
		this.gender=gender;
		return this;
	}
	/**
	 * @param dobString the dobString to set
	 */
	public ContactBuilder setDobString(String dobString) {
		this.dobString = dobString;
		return this;
	}
	/**
	 * @param email the email to set
	 */
	public ContactBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	/**
	 * @param address the address to set
	 */
	public ContactBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public ContactBuilder setPincode(int pincode) {
		this.pincode = pincode;
		return this;
	}
	/**
	 * @param home the home to set
	 */
	public ContactBuilder setHome(long home) {
		this.home = home;
		return this;
	}
	/**
	 * @param work the work to set
	 */
	public ContactBuilder setWork(long work) {
		this.work = work;
		return this;
	}
	/**
	 * @param landline the landline to set
	 */
	public ContactBuilder setLandline(long landline) {
		this.landline = landline;
		return this;
	}
	
	public Contact buildContact()
	{
//		Contact contact = new Contact(id, firstName, lastName, mobile, age, gender, dobString, email, address, pincode, home, work, landline);
//		return contact;
		return new Contact(id, firstName, lastName, mobile, age, gender, dobString, email, address, pincode, home, work, landline);
	}
	
}
