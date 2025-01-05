package com.jspiders.SPRING_CORE_XML.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.SPRING_CORE_XML.bean.Person;

public class PersonMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Person_Config.xml");
		
		Person person = (Person) applicationContext.getBean("person");
		
		System.out.println(person);
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}

}