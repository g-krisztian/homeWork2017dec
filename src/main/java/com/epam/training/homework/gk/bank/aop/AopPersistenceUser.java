package com.epam.training.homework.gk.bank.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.user.User;

public class AopPersistenceUser extends AopPersistence {

	public AopPersistenceUser(DbConnector dbConnector) {
		super(dbConnector);
	}

	public User getUserById(ProceedingJoinPoint pjp) throws Throwable {

		Long id = (Long) pjp.getArgs()[0];
		System.out.println(id);
		return dbConnector.getUserById(id);
	}

	public List<User> getUsers(ProceedingJoinPoint pjp) {
		return dbConnector.getUsers();
	}
	
	public User findByName(ProceedingJoinPoint pjp) {
		String name = (String) pjp.getArgs()[0];
		return dbConnector.getUserByName(name);
	}
}
