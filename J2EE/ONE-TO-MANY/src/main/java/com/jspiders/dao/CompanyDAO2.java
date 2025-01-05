/* DELETE THE RECORD FROM DATABASE USING HIBERNATE
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

package com.jspiders.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.CompanyDTO;
import com.jspiders.dto.EmployeeDTO;

public class CompanyDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		CompanyDTO companyDTO=entityManager.find(CompanyDTO.class,1);
		System.out.println(companyDTO);
		
		List<EmployeeDTO>employeeDTO=companyDTO.getEmployeeDTOs();
		EmployeeDTO deleteEmployeeDTO=null;
		
		for (EmployeeDTO employee : employeeDTO) {
			if (employee.getId()==1) {
				deleteEmployeeDTO=employee;
			}
		}
		employeeDTO.remove(deleteEmployeeDTO);
		
		companyDTO.setEmployeeDTOs(employeeDTO);
		entityManager.persist(companyDTO);
		
		EmployeeDTO employee =entityManager.find(EmployeeDTO.class,1);
		entityManager.remove(employee);
		
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
