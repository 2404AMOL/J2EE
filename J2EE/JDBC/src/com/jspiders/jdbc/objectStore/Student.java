package com.jspiders.jdbc.objectStore;

public class Student {
	
	private int id;
	private String fname="";
	private String lname="";
	private long contact;
	private String gmail="";
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the contact
	 */
	public long getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(long contact) {
		this.contact = contact;
	}
	/**
	 * @return the gmail
	 */
	public String getGmail() {
		return gmail;
	}
	/**
	 * @param gmail the gmail to set
	 */
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", contact=" + contact + ", gmail="
				+ gmail + "]";
	}
	
}
