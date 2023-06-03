package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.CompanyDTO;
import com.jspiders.hibernateonetomany.dto.EmployeeDTO;

public class EmployeeCompanyDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("onetomany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
			;
		}
	}

	public static void main(String[] args) {

		try {
			openConnection();
			transaction.begin();

			EmployeeDTO emp1 = new EmployeeDTO();
			emp1.setId(1);
			emp1.setName("Parshu");
			emp1.setDesignation("manager");
			emp1.setSalary(70000);
			manager.persist(emp1);

			EmployeeDTO emp2 = new EmployeeDTO();
			emp2.setId(2);
			emp2.setName("Amol");
			emp2.setDesignation("Team Lead");
			emp2.setSalary(50000);
			manager.persist(emp2);

			EmployeeDTO emp3 = new EmployeeDTO();
			emp3.setId(3);
			emp3.setName("Santu");
			emp3.setDesignation("HR");
			emp3.setSalary(40000);
			manager.persist(emp3);

			List<EmployeeDTO> employees = Arrays.asList(emp1, emp2, emp3);

			CompanyDTO companyDTO = new CompanyDTO();
			companyDTO.setId(1);
			companyDTO.setName("TCS");
			companyDTO.setDoe("01-05-1996)");
			companyDTO.setAddress("Pune");
			companyDTO.setEmployees(employees);
			manager.persist(companyDTO);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}
}
