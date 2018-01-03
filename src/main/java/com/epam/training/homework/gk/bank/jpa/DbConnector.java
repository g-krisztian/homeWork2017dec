package com.epam.training.homework.gk.bank.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnector {
	
	
	
	private EntityManagerFactory emf;

	public DbConnector() {
		
		emf = Persistence.createEntityManagerFactory("homeWork");

		
		emf.close();
	}

}
