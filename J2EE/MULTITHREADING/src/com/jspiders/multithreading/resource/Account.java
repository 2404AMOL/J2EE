package com.jspiders.multithreading.resource;


public class Account {

	private int balance;
	
	public Account(int balance)
	{
		this.balance = balance;
	}
	
	public synchronized void deposite(int money)
	{
		System.out.println("Trying To Deposite :- "+money+"Rs.");
		balance+=money;
		System.out.println("Deposite Successful");
		System.out.println("Account Balance :- "+checkBalance());
	}
	
	public synchronized void withdraw(int money)
	{
		System.out.println("Trying To Withdraw :- "+money+"Rs.");
		balance-=money;
		System.out.println("Withdraw Successful");
		System.out.println("Account Balance :- "+checkBalance());
	}
	public int checkBalance() {
		return balance;
	}
}
