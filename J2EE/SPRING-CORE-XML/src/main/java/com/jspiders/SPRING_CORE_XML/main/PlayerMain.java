package com.jspiders.SPRING_CORE_XML.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.SPRING_CORE_XML.bean.Player;
import com.jspiders.SPRING_CORE_XML.bean.Team;

public class PlayerMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Player_Config.xml");
		Team team = (Team)applicationContext.getBean("team");
		
		System.out.println(team);
		
		Player player1 = (Player) applicationContext.getBean("player1");
		System.out.println(player1);
		
		Player player2 = (Player)applicationContext.getBean("player2");
		System.out.println(player2);
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
