package com.jspiders.hibernatemanytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytoone.dto.PlayersDTO;
import com.jspiders.hibernatemanytoone.dto.TeamDTO;

public class PlayersTeamDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("manyToOne");
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

			TeamDTO team1 = new TeamDTO();
			team1.setId(1);
			team1.setName("CSK");
			team1.setCity("Chennai");
			manager.persist(team1);

			TeamDTO team2 = new TeamDTO();
			team2.setId(2);
			team2.setName("MI");
			team2.setCity("Mumbai");
			manager.persist(team2);

			PlayersDTO player1 = new PlayersDTO();
			player1.setId(1);
			player1.setName("M S Dhoni");
			player1.setRole("wk/Bat");
			player1.setJersey(07);
			player1.setAge(41);
			player1.setTeam(team1);
			manager.persist(player1);

			PlayersDTO player2 = new PlayersDTO();
			player2.setId(2);
			player2.setName("Rohit Sharma");

			player2.setRole("Bat");
			player2.setJersey(45);
			player2.setAge(36);
			player2.setTeam(team2);
			manager.persist(player2);

			PlayersDTO player3 = new PlayersDTO();
			player3.setId(3);
			player3.setName("Jadeja");
			player3.setRole("All Rounder");
			player3.setJersey(8);
			player3.setAge(34);
			player3.setTeam(team1);
			manager.persist(player3);

			PlayersDTO player4 = new PlayersDTO();
			player4.setId(4);
			player4.setName("S K Yadav");
			player4.setRole("Bat");
			player4.setJersey(63);
			player4.setTeam(team2);
			manager.persist(player4);

			transaction.commit();

		} finally {
			closeConnection();
		}
	}
}
