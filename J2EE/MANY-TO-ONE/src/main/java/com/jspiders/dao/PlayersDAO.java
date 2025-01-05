package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.PlayersDTO;
import com.jspiders.dto.TeamDTO;

public class PlayersDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		PlayersDTO playersDTO1 = new PlayersDTO();
		playersDTO1.setId(1);
		playersDTO1.setName("Rohit");
		playersDTO1.setAge(38);
		playersDTO1.setJerseyNumber(45);
		
		PlayersDTO playersDTO2 = new PlayersDTO();
		playersDTO2.setId(2);
		playersDTO2.setName("Virat");
		playersDTO2.setAge(35);
		playersDTO2.setJerseyNumber(18);
		
		PlayersDTO playersDTO3 = new PlayersDTO();
		playersDTO3.setId(3);
		playersDTO3.setName("Shubhman");
		playersDTO3.setAge(27);
		playersDTO3.setJerseyNumber(11);
		
		PlayersDTO playersDTO4 = new PlayersDTO();
		playersDTO4.setId(4);
		playersDTO4.setName("Hardik");
		playersDTO4.setAge(29);
		playersDTO4.setJerseyNumber(22);
		
		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(1);
		teamDTO.setName(" Team A");
		teamDTO.setCountry("India");
		
		playersDTO1.setTeamDTO(teamDTO);
		playersDTO2.setTeamDTO(teamDTO);
		playersDTO3.setTeamDTO(teamDTO);
		playersDTO4.setTeamDTO(teamDTO);
		
		entityManager.persist(teamDTO);
		entityManager.persist(playersDTO1);
		entityManager.persist(playersDTO2);
		entityManager.persist(playersDTO3);
		entityManager.persist(playersDTO4);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("Team");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection()
	{
		if (entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if (entityManager!=null) {
			entityManager.close();
		}
		if (entityTransaction!=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
