package com.epam.training.homework.gk.bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.jpa.DbConnector;

public class AopPersistence {
	DbConnector dbConnector;

	public AopPersistence(DbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public <T extends Persist> T saveCreated(ProceedingJoinPoint pjp) throws Throwable {
		
		T created = (T) pjp.proceed();
		
		System.out.println("\tsaveCreated SAVING " + created);
		
		created.setId(null);
		dbConnector.saveAny(created);
		return created;
	}

	public <T extends Persist> void afterChange(ProceedingJoinPoint pjp) throws Throwable {
		
		pjp.proceed();
		Object[] args2 = pjp.getArgs();
		System.out.println("\tafterChange SAVING: "+args2);
		for (Object object : args2) {
			dbConnector.saveAny((T) object);
		}
		//T[] args = (T[]) args2;

		//dbConnector.saveMany(args2);

	}

}
