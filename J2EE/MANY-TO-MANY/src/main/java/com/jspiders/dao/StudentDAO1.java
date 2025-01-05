package com.jspiders.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.CoursesDTO;
import com.jspiders.dto.StudentsDTO;

public class StudentDAO1 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;


	public static void main(String[] args) {

		openConnection();
		entityTransaction.begin();
		
		
		StudentsDTO studentsDTO = entityManager.find(StudentsDTO.class,2);
		List<CoursesDTO> coursesList = new ArrayList<CoursesDTO>();
		
		CoursesDTO courses = null;
		
		for (CoursesDTO coursesDTO : coursesList) {
			if (courses.getCourseName().equals("J2EE")) {
				courses=coursesDTO;
			}
		}
		
		coursesList.remove(courses);
		entityManager.persist(studentsDTO);
		
		studentsDTO.setCoursesDTOs(coursesList);
		entityManager.persist(studentsDTO);
		CoursesDTO coursesDTO = entityManager.find(CoursesDTO.class, 4);
		entityManager.remove(coursesDTO);
		
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
	}
}
