package com.jspiders.SPRING_CORE_ANNOTATION.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.SPRING_CORE_ANNOTATION.bean.Person;

public class PersonMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jspiders.SPRING_CORE_ANNOTATION");
		
		Person person = (Person) applicationContext.getBean("personBean");
		
		System.out.println(person);
		
		((AnnotationConfigApplicationContext)applicationContext).close();
		
		
	}
}
