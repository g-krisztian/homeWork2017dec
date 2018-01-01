package com.epam.training.homework.gk.bank.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epam.training.homework.gk.bank.user.User;
import com.epam.training.homework.gk.bank.user.UserDaoPersist;

public class JpaApplication {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("homeWork");

		EntityManager em = emf.createEntityManager();

		
		em.close();

		emf.close();
	}

	private static void soutList(List<?> users) {
		System.out.println(users);
	}
}
