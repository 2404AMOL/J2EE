package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.dto.StudentDTO;

public class StudentDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Query query=entityManager.createQuery("Select studentdto from StudentDTO studentdto where id=?1");
		query.setParameter(1,1);
		@SuppressWarnings("unchecked")
		java.util.List<StudentDTO> list=query.getResultList();
		
		for (StudentDTO studentDTO : list) {
			System.out.println(studentDTO);
		}
	
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
