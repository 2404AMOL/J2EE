package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.AadharCardDTO;
import com.jspiders.dto.PersonDTO;

public class PersonDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		
		AadharCardDTO aadharCardDTO=new AadharCardDTO();
		
		aadharCardDTO.setAadharNum(931300905827L);
		entityManager.persist(aadharCardDTO);
		
		PersonDTO personDTO=new PersonDTO();
		personDTO.setName("Amol");
		personDTO.setPhoneNo(9373428581L);
		personDTO.setEmail("24amolpawar@gmail.com");
		personDTO.setAadharCardDTO(aadharCardDTO);
		entityManager.persist(personDTO);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("Person");
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
