package com.epam.training.homework.gk.bank.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.jpa.DbConnector;

public class AopPersistenceTransfer extends AopPersistence{

	public AopPersistenceTransfer(DbConnector dbConnector) {
		super(dbConnector);
	}
	
	public <T extends Persist> void updateTransfer(JoinPoint pjp) {
		
		System.out.println("\nIn updateTransfer with: " + pjp.getSourceLocation() + "\n");
		
		Object[] objArgs = pjp.getArgs();
		Transfer transfer = (Transfer) objArgs[1];
		Account account = (Account) objArgs[0];
		
		dbConnector.updateTransfer(transfer);
		dbConnector.updateAccount(account);

	}

	public List<Transfer> getTransfers(ProceedingJoinPoint pjp) {
		return dbConnector.getTransfers();
	}


}
