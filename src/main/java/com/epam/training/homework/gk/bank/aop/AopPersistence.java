package com.epam.training.homework.gk.bank.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.jpa.DbConnector;

public class AopPersistence {
	DbConnector dbConnector;

	public AopPersistence(DbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public <T extends Persist> T saveCreated(ProceedingJoinPoint pjp) throws Throwable {
		@SuppressWarnings("unchecked")
		T created = (T) pjp.proceed();
		created.setId(null);
		dbConnector.saveNew(created);
		return created;
	}

	public <T extends Persist> T update(ProceedingJoinPoint pjp) throws Throwable {
		Object[] objArgs = pjp.getArgs();
		List<T> listArgs = tryConvert(objArgs);

		@SuppressWarnings("unchecked")
		
		T t = (T) pjp.proceed();
		dbConnector.saveMany(listArgs);
		return t;
	}

	public <T extends Persist> T markDelete(ProceedingJoinPoint pjp) throws Throwable {
		Object[] objArgs = pjp.getArgs();
		List<T> listArgs = tryConvert(objArgs);

		@SuppressWarnings("unchecked")
		T t = (T) pjp.proceed();
		t.setActive(false);
		dbConnector.saveMany(listArgs);
		return t;
	}
	

	@SuppressWarnings("unchecked")
	private <T extends Persist> List<T> tryConvert(Object[] args) {
		List<T> args1 = new ArrayList<T>();

		try {
			for (int i = 0; i < args.length; i++) {
				args1.add((T) args[i]);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return args1;
	}

}
