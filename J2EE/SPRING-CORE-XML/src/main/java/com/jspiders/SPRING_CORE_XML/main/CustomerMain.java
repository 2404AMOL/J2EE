package com.jspiders.SPRING_CORE_XML.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.SPRING_CORE_XML.bean.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Customer_Config.xml");
		
		Customer customer1 = (Customer) applicationContext.getBean("customer1");
		System.out.println(customer1);
		
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
