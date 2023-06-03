package com.jspiders.hibernate_mapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_mapping.dto.AadharDTO;
import com.jspiders.hibernate_mapping.dto.PersonDTO;

public class PersonAadharDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToOne");
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
		}
	}

	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			AadharDTO aadhar1 = new AadharDTO();
			aadhar1.setId(1);
			aadhar1.setAadhar_no(831063748385l);
			aadhar1.setDoi("01-12-2014");
			
			manager.persist(aadhar1);

			PersonDTO person1 = new PersonDTO();
			person1.setId(1);
			person1.setName("Parshu");
			person1.setContact(9607804767l);
			person1.setDob("15-11-2001");
			person1.setAddress("Pune");
			person1.setAadhar(aadhar1);

			manager.persist(person1);

			transaction.commit();

		} finally {

			closeConnection();

		}
	}

}
