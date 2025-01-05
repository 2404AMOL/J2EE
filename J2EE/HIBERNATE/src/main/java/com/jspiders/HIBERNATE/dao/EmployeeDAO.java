package com.jspiders.HIBERNATE.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.HIBERNATE.dto.EmployeeDTO;

public class EmployeeDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	

	public static void main(String[] args) {
		

		entityManagerFactory=Persistence.createEntityManagerFactory("employee");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
		EmployeeDTO employeeDTO =new EmployeeDTO();
		employeeDTO.setId(1);
		employeeDTO.setName("Amol Pawar");
		employeeDTO.setEmail("24amolpawar@gmail.com");
		employeeDTO.setMobile(9373428581L);
		employeeDTO.setAddress("Bhalawani");
		
		employeeDTO.setId(2);
		employeeDTO.setName("Ganesh Gidde");
		employeeDTO.setEmail("ganesh@gmail.com");
		employeeDTO.setMobile(9374676434L);
		employeeDTO.setAddress("Vadikurvalio");
		
		entityTransaction.begin();
		entityManager.persist(employeeDTO);
		entityTransaction.rollback();
		entityManager.close();
		entityManagerFactory.close();
			
	}
	
}
