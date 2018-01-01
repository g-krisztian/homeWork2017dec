package com.epam.training.homework.gk.bank.in_memory.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaApplication {
	public static void main(String[] args) {
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("homeWork");

		EntityManager em = emf.createEntityManager();

		
		em.close();

		emf.close();
	}

}
