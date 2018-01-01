package com.epam.training.homework.gk.bank.application;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaApplication {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("homeWork"); 
		
		emf.close();
	}

	private static void soutList(List<?> users) {
		System.out.println(users);
	}
}
