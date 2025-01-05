package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		StudentDTO studentDTO=new StudentDTO();
		
		studentDTO.setId(1);
		studentDTO.setName("Amol Pawar");
		studentDTO.setAge(24);
		studentDTO.setContact(9373428581L);
		studentDTO.setAddress("Bhalawani");
		studentDTO.setFees(32000.00);
		
		studentDTO.setId(2);
		studentDTO.setName("Ganesh Gidde");
		studentDTO.setContact(3878738734L);
		studentDTO.setAge(24);
		studentDTO.setAddress("Vadkuravli");
		studentDTO.setFees(25000);
		
		entityManager.persist(studentDTO);
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("student");
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
