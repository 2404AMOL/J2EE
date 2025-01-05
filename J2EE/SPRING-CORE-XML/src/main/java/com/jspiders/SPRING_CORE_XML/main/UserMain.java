package com.jspiders.SPRING_CORE_XML.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.SPRING_CORE_XML.bean.User;

public class UserMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("User_config.xml");
		
		User user = (User) applicationContext.getBean(User.class);
		System.out.println(user);
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}
}
