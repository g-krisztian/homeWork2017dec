package com.epam.training.homework.gk.bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.jpa.DbConnector;

public class AopPersistance {
	DbConnector dbConnector;

	public AopPersistance(DbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public <T extends Persist> T saveCreated(ProceedingJoinPoint pjp) throws Throwable {

		T created = (T) pjp.proceed();
		
		created.setId(null);
		dbConnector.saveAny(created);
		return created;
	}

	public <T extends Persist> void afterChange(ProceedingJoinPoint pjp) throws Throwable {
		T[] args = (T[]) pjp.getArgs();
		
			dbConnector.saveMany(args);
		
	}
	
	
	
}
