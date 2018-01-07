package com.epam.training.homework.gk.bank.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.jpa.DbConnector;

public class AopPersistenceAccount extends AopPersistence{

	public AopPersistenceAccount(DbConnector dbConnector) {
		super(dbConnector);
	}
	
	public Account getAccountById(ProceedingJoinPoint pjp) throws Throwable {

		Long id = (Long) pjp.getArgs()[0];

		return dbConnector.getAccountById(id);
	}
	
	public List<Account> getAccounts(ProceedingJoinPoint pjp) {
		return dbConnector.getAccounts();
	}
	
}
