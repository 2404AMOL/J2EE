package com.jspiders.designpatterns.structural.Adapter;

public class EmployeeAdapter extends Employee implements Events  {
	
	public static void main(String[] args) {
		EmployeeAdapter employeeAdapter = new EmployeeAdapter();
		employeeAdapter.womensDay();
		employeeAdapter.mensDay();
	}
	@Override
	public void womensDay() {
		EmployeeAdapter employeeAdapter = new EmployeeAdapter();
		employeeAdapter.setId(1);
		employeeAdapter.setName("Radha");
		employeeAdapter.setEmail("radha@gmail.com");
		System.out.println("Chief guest for the women's day is " + employeeAdapter.getName());

	}

	@Override
	public void mensDay() {
		EmployeeAdapter employeeAdapter = new EmployeeAdapter();
		employeeAdapter.setId(1);
		employeeAdapter.setName("Ramesh");
		employeeAdapter.setEmail("ramesh@gmail.com");
		System.out.println("Chief guest for the men's day is " + employeeAdapter.getName());

	}
}
