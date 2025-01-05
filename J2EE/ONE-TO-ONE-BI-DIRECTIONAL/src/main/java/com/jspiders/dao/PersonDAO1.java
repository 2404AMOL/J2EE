package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.AadharCardDTO;
import com.jspiders.dto.PersonDTO;

public class PersonDAO1 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		PersonDTO personDTO = entityManager.find(PersonDTO.class, 1);
		entityManager.remove(personDTO);
		
		AadharCardDTO aadharCardDTO = personDTO.getAadharCardDTO();
		entityManager.remove(aadharCardDTO);
		
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
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
