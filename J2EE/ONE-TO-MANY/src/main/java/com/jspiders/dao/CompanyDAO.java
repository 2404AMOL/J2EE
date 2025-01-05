package com.jspiders.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.CompanyDTO;
import com.jspiders.dto.EmployeeDTO;

public class CompanyDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		CompanyDTO companyDTO= new CompanyDTO();
		companyDTO.setId(1);
		companyDTO.setName("Infosys");
		companyDTO.setEmail("infosys@gmail.com");
		companyDTO.setAddress("Pune");
		
		EmployeeDTO employeeDTO1 = new EmployeeDTO();
		employeeDTO1.setId(1);
		employeeDTO1.setName("Amol");
		employeeDTO1.setEmail("24amolpawar@gmail.com");
		employeeDTO1.setSalary(35000.00);
		
		EmployeeDTO employeeDTO2 = new EmployeeDTO();
		employeeDTO2.setId(2);
		employeeDTO2.setName("Ganesh");
		employeeDTO2.setEmail("ganesh@gmail.com");
		employeeDTO2.setSalary(22000.00);
		
		EmployeeDTO employeeDTO3= new EmployeeDTO();
		employeeDTO3.setId(3);
		employeeDTO3.setName("Pavan");
		employeeDTO3.setEmail("pavan@gmail.com");
		employeeDTO3.setSalary(29000.00);
		
		List<EmployeeDTO> employees = new ArrayList<>();
		employees.add(employeeDTO1);
		employees.add(employeeDTO2);
		employees.add(employeeDTO3);
		
		companyDTO.setEmployeeDTOs(employees);
		
		entityManager.persist(employeeDTO1);
		entityManager.persist(employeeDTO2);
		entityManager.persist(employeeDTO3);
		entityManager.persist(companyDTO);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
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
