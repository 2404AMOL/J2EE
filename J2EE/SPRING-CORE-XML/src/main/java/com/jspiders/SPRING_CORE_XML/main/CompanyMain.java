package com.jspiders.SPRING_CORE_XML.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.SPRING_CORE_XML.bean.Company;

public class CompanyMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Company_Config.xml");
		
		Company company = (Company) applicationContext.getBean("company");
		System.out.println(company);
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}

}
