package com.jspiders.SPRING_CORE_XML.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.SPRING_CORE_XML.bean.Mobile;

public class MobileMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Mobile_config.xml");
		
		Mobile mobile = (Mobile) applicationContext.getBean("mobile");
		System.out.println(mobile);
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}
}
