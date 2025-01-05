package com.jspiders.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.CoursesDTO;
import com.jspiders.dto.StudentsDTO;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
	
		CoursesDTO coursesDTO1 = new CoursesDTO();
		coursesDTO1.setCourseName("SQL");
		coursesDTO1.setFees(5000.00);
		
		CoursesDTO coursesDTO2 = new CoursesDTO();
		coursesDTO2.setCourseName("CORE JAVA");
		coursesDTO2.setFees(10000.00);
		
		CoursesDTO coursesDTO3 = new CoursesDTO();
		coursesDTO3.setCourseName("WEBTECH");
		coursesDTO3.setFees(15000.00);
		
		CoursesDTO coursesDTO4 = new CoursesDTO();
		coursesDTO4.setCourseName("J2EE");
		coursesDTO4.setFees(20000.00);
		
		StudentsDTO studentDTO1 = new StudentsDTO();
		studentDTO1.setName("Amol");
		studentDTO1.setAge(24);
		studentDTO1.setEmail("24amolpawar@gmail.com");
		studentDTO1.setCoursesDTOs(Arrays.asList(coursesDTO1, coursesDTO3));
		entityManager.persist(studentDTO1);
		
		StudentsDTO studentDTO2 = new StudentsDTO();
		studentDTO2.setName("Rushi");
		studentDTO2.setAge(25);
		studentDTO2.setEmail("rushimisal5@gmail.com");
		studentDTO2.setCoursesDTOs(Arrays.asList(coursesDTO2, coursesDTO4));
		entityManager.persist(studentDTO2);
		
		
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
