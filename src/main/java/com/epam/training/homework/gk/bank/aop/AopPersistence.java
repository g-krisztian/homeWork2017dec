package com.epam.training.homework.gk.bank.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.user.User;

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

	public <T extends Persist> void updateTransfer(ProceedingJoinPoint pjp) throws Throwable {

		Object[] objArgs = pjp.getArgs();
		Transfer transfer = (Transfer) objArgs[0];
		

		pjp.proceed();

		Account fromAccount = transfer.getFromAccount();
		if (fromAccount != null) {
			dbConnector.update(fromAccount);
		}

		Account toAccount = transfer.getToAccount();
		if (toAccount != null) {
			dbConnector.update(toAccount);
		}
		dbConnector.update(transfer);

	}

	public User getUserById(ProceedingJoinPoint pjp) throws Throwable {

		Long id = (Long) pjp.getArgs()[0];
		System.out.println(id);
		return dbConnector.getUserById(id);
	}

	public Account getAccountById(ProceedingJoinPoint pjp) throws Throwable {

		Long id = (Long) pjp.getArgs()[0];

		return dbConnector.getAccountById(id);
	}

	public List<Transfer> getTransfers(ProceedingJoinPoint pjp) {
		return dbConnector.getTransfers();
	}

	public List<User> getUsers(ProceedingJoinPoint pjp) {
		return dbConnector.getUsers();
	}

	public List<Account> getAccounts(ProceedingJoinPoint pjp) {
		return dbConnector.getAccounts();
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
